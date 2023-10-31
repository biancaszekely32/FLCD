public class SymbolTableString {
    private HashTable<String> hashTable;

    public SymbolTableString(Integer size) {
        hashTable = new HashTable<>(size);
    }

    public boolean addSymbolString(String symbol) {
        if (hashTable.put(symbol))
            return hashTable.put(symbol);
        return false;
    }

    public Integer getSymbolPosition(String symbol) {
        Pair position = hashTable.findPosOfKey(symbol);
        if (position != null) {
            return (Integer) position.getPos();
        }
        return null;
    }

    public String getSymbol(Pair position) {
        return hashTable.get(position);
    }

    public String getSymbolByPos(int position) {
        return hashTable.getByPos(position);
    }

    public String displayTable() {
        return hashTable.displayTable();
    }}