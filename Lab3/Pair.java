public class Pair<T,U> {
    private T pos;
    private U symbol;

    public Pair(T pos, U symbol) {
        this.pos = pos;
        this.symbol = symbol;
    }

    public T getPos() {
        return pos;
    }

    public U getSymbol() {
        return symbol;
    }

    public T setPos(T pos) {
        return this.pos = pos;
    }

    public U setSymbol(U symbol) {
        return this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "(" + pos + ", " + symbol + ")";
    }
}
