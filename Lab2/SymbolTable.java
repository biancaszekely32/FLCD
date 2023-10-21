import java.util.ArrayList;

public class SymbolTable<T> {

    private HashTable<T> hashTable;

    public SymbolTable(Integer size) {
        hashTable = new HashTable<>(size);
    }

    public boolean addSymbol(T symbol) {
        if (hashTable.put(symbol))
            return hashTable.put(symbol);
        return false;
    }

    public Integer getSymbolPosition(T symbol) {
        Pair position = hashTable.findPosOfKey(symbol);
        if (position != null) {
            return position.getPos();
        }
        return null;
    }

    public T getSymbol(Pair position) {
        return hashTable.get(position);
    }

    public T getSymbolByPos(int position) {
        return hashTable.getByPos(position);
    }

    public String displayTable() {
        return hashTable.displayTable();
    }}