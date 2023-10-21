
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        SymbolTable<Integer> intSymbolTable = new SymbolTable<>(5);
        SymbolTable<String> stringSymbolTable = new SymbolTable<>(5);

        System.out.println("Integer Symbol Table:");
        System.out.println("Initial Table: " + intSymbolTable.displayTable());

        intSymbolTable.addSymbol(10);
        System.out.println("Table after adding 10: " + intSymbolTable.displayTable());

        intSymbolTable.addSymbol(15);
        System.out.println("Table after adding 15: " + intSymbolTable.displayTable());

        intSymbolTable.addSymbol(24);
        System.out.println("Table after adding 24: " + intSymbolTable.displayTable());

        Integer intKeyToFind = 15;
        System.out.println("Position of key " + intKeyToFind + ": " + intSymbolTable.getSymbolPosition(intKeyToFind));

        System.out.println("\nString Symbol Table:");
        stringSymbolTable.addSymbol("apple");
        System.out.println("Table after adding 'apple': " + stringSymbolTable.displayTable());

        stringSymbolTable.addSymbol("banana");
        System.out.println("Table after adding 'banana': " + stringSymbolTable.displayTable());

        String stringKeyToFind = "banana";
        Integer stringPosition = stringSymbolTable.getSymbolPosition(stringKeyToFind);
        System.out.println("Position of key " + stringKeyToFind + ": " + stringPosition);


    }
}
