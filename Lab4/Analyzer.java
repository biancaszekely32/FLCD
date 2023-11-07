import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Analyzer {
    private final String filename;
    private Language language;
    private SymbolTableString symbolTableString ;
    private SymbolTableInteger symbolTableInteger ;

    private ProgramInternalForm pif;


    public Analyzer(String filename) {
        this.filename = filename;
        this.language = new Language();
        this.symbolTableString = new SymbolTableString(50);
        this.symbolTableInteger = new SymbolTableInteger(50);
        this.pif = new ProgramInternalForm();

    }


    public void analyze() {
        List<Pair<String, Integer>> tokenWithLine = new ArrayList<>();
        try {
            File sourceFile = new File(filename);
            Scanner sc = new Scanner(sourceFile);

            int lineNr = 1;
            while(sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                List<String> tokensOnLine = tokenize(currentLine);
                for(String token : tokensOnLine) {
                    tokenWithLine.add(new Pair<>(token, lineNr));
                }
                lineNr += 1;
            }

            sc.close();
            buildTables(tokenWithLine);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> tokenize(String line) {
        ArrayList<String> tokens = new ArrayList<>();

        for(int i = 0; i < line.length(); i++) {
            char currentCharacter = line.charAt(i);
            //add a non-space separator to the tokens list
            if(language.isSeparator(String.valueOf(currentCharacter)) && !(String.valueOf(currentCharacter)).equals(" ")) {
                tokens.add(String.valueOf(currentCharacter));
            }
            //
            else if (currentCharacter == '\"') {
                String stringConstant = identifyString(line, i);
                tokens.add(stringConstant);
                i += stringConstant.length() - 1;
            }
            else if (currentCharacter == '\'' && line.charAt(i + 2) == '\'') {
                String charConstant = identifyString(line, i);
                tokens.add(charConstant);
                i += charConstant.length() - 1;
            }
            else if(language.isPartOfOperator(line.charAt(i)))  {
                String operator = identifyOperator(line, i);
                tokens.add(operator);
                i += operator.length() - 1;

            }
            else if (line.charAt(i) != ' ') {
                String otherToken = identifyToken(line, i);
                tokens.add(otherToken);
                i += otherToken.length() - 1;
            }
        }
        return tokens;
    }

    public String identifyString(String line, int index) {
        StringBuilder constant = new StringBuilder();
        for(int i = index; i<line.length(); i++) {
            char currentCharacter = line.charAt(i);
            constant.append(currentCharacter);
        }
        return constant.toString();
    }

    public String identifyOperator(String line, int index) {
        StringBuilder operator = new StringBuilder();
        operator.append(line.charAt(index));
        operator.append(line.charAt(index + 1));
        if(language.isOperator(operator.toString()))
            return operator.toString();
        return String.valueOf(line.charAt(index));
    }

    public String identifyToken(String line, int index) {
        StringBuilder token = new StringBuilder();
        for(int i = index; i < line.length() && !language.isSeparator(String.valueOf(line.charAt(i)))
                && !language.isPartOfOperator(line.charAt(i))
                && line.charAt(i) != ' '; i++ ) {
            token.append(line.charAt(i));
        }

        return token.toString();
    }

    // codes:
    // 0 - constant
    // 1 - identifier
    // -1 - operator, separator, reserved
    private void buildTables(List<Pair<String, Integer>> tokensWithLine) {
        boolean isCorrect = true;
        for(Pair<String, Integer> tokenPair: tokensWithLine) {
            String token = tokenPair.getPos();

            if(language.isReservedWord(token) || language.isSeparator(token) || language.isOperator(token)) {
                int code = language.getCode(token);
                pif.addToPif(token, new Pair<>(code, -1));
            }
            else if(language.isIdentifier(token)) {
                this.symbolTableString.addSymbolString(token);
                int positionInSymbolTable = this.symbolTableString.getSymbolPosition(token);
                pif.addToPif(token, new Pair<>(1, positionInSymbolTable));
            } else if(language.isConstant(token)) {
                this.symbolTableInteger.addSymbolInteger(Integer.valueOf(token));
                int positionInSymbolTable = this.symbolTableInteger.getSymbolPosition(Integer.valueOf(token));
                pif.addToPif(token, new Pair<>(0, positionInSymbolTable));
            } else {
                System.out.println("Error on line " + tokenPair.getSymbol() + ": invalid token " + token);
                isCorrect = false;
                break;
            }
        }
        if(isCorrect) {
            System.out.println("Program is lexically correct.");
        }
        else {
            System.out.println("Program is not lexically correct.");
        }
        writeResults();
    }



    private void writeResults() {
        try {
            deleteIfExists("SymbolTable.txt");
            FileWriter symbolTableFileWriter = new FileWriter("SymbolTable.txt", true);
            try (BufferedWriter symbolTableWriter = new BufferedWriter(symbolTableFileWriter)) {
                symbolTableWriter.write("The symbol table is implemented as a hash table.\n");
                symbolTableWriter.write("Identifiers:\n");
                symbolTableWriter.write(symbolTableString.displayTable());
                symbolTableWriter.write("\n");
                symbolTableWriter.write("Constants:\n");
                symbolTableWriter.write(symbolTableInteger.displayTable());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            deleteIfExists("ProgramInternalForm.txt");
            FileWriter pifFileWriter = new FileWriter("ProgramInternalForm.txt", true);
            try (BufferedWriter pifWriter = new BufferedWriter(pifFileWriter)) {
                pifWriter.write("Program Internal Form:\n");
                pifWriter.write(pif.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteIfExists(String filePath) {
        try {
            Files.deleteIfExists(new File(filePath).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


