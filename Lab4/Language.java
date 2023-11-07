import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Language {
    private List<String> operators;
    private List<String> separators;
    private List<String> reservedWords;
    private final HashMap<String, Integer> tokens;

    public Language() {
        operators = new ArrayList<>(List.of("+", "-", "*", "/", "%", "<", ">", "<=", ">=", "=", "and", "or", "is"));
        separators = new ArrayList<>(List.of("[", "]", "(", ")", "{", "}", ":", ";", ",", "'", " ", "\n", "\t","."));
        reservedWords = new ArrayList<>(List.of("if", "@", "else", "read", "write", "integer", "string", "for", "in", "range", "while"));

        tokens = new HashMap<>();
        loadListOfTokens();
    }

    private void loadListOfTokens() {
        tokens.put("identifier", 1);
        tokens.put("constant", 0);

        int next = 2;

        List<List<String>> tokenGroups = List.of(reservedWords, separators, operators);

        for (List<String> tokenGroup : tokenGroups) {
            for (String token : tokenGroup) {
                tokens.put(token, next++);
            }
        }
    }

    public Integer getCode(String token) {
        return tokens.get(token);
    }

    public boolean isOperator(String token) {
        return operators.contains(token);
    }

    public boolean isPartOfOperator(char op) {
        // the case when we encounter ">= or <="
        return op == '>' || isOperator(String.valueOf(op)) || op == '<';

    }

    public boolean isSeparator(String token) {
        return separators.contains(token);
    }

    public boolean isReservedWord(String token) {
        return reservedWords.contains(token);
    }

    public boolean isIdentifier(String token) {
        String identifierPattern = "^[a-zA-Z]([a-zA-Z0-9_]*$)";
        return token.matches(identifierPattern);
    }

    public boolean isConstant(String token) {
        String integerPattern = "^0|[+|-][1-9]([0-9])*|[1-9]([0-9])*$";
        String characterPattern ="^\'[a-zA-Z0-9_?!#*,./%-+=<>;)(}{ ]\'";
        String stringPattern = "^\"[a-zA-Z0-9_?!#*,./%-+=<>;)(}{ ]*\"";

        return token.matches(integerPattern) || token.matches(characterPattern) || token.matches(stringPattern);
    }

}
