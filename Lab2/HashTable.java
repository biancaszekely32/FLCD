import java.util.ArrayList;
import java.util.List;

class Pair {
    private final Integer pos,symbol;

    public Pair(Integer pos, Integer symbol) {
        this.pos = pos;
        this.symbol = symbol;
    }

    public Integer getPos() {
        return pos;
    }

    public Integer getSymbol() {
        return symbol;
    }

    public String toString() {
        return "(" + pos + ", " + symbol + ")";
    }
}
public class HashTable<T> {

    private Integer size;
    private ArrayList<ArrayList<T>> table;

    public HashTable(Integer size) {
        this.size = size;
        this.table = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.table.add(new ArrayList<>());
        }
    }

    public Integer hash(T key) {
        int hash=-1;
        if (key instanceof Integer) {
            hash = (int) key % size;
        } else if (key instanceof String) {
            for (char c : ((String) key ).toCharArray()) {
                hash = (31 * hash + c) % size;
            }
            hash= Math.abs(hash);
        }
        return hash;
    }

    public Integer getSize() {
        return size;
    }

    public Pair findPosOfKey(T key) {
        int index = hash(key);

        if (!table.get(index).isEmpty()) {
            ArrayList<T> elems = this.table.get(index);
            for (int i = 0; i < elems.size(); i++) {
                if (elems.get(i).equals(key)) {
                    return new Pair(index, i);
                }
            }
        }
        return null;
    }

    public boolean put(T key) {
        if (findPosOfKey(key) == null) {
            int index = hash(key);
            ArrayList<T> list = this.table.get(index);
            list.add(key);
            return true;
        }
        else return false;
    }


    public T get(Pair key) {
        int pos = key.getPos();
        int symbol = key.getSymbol();
        return this.table.get(pos).get(symbol);
    }

    public T getByPos(int pos) {
        return this.table.get(pos).get(0);
    }


    public String displayTable() {
        return "ST { " + table+ " }";
    }
}