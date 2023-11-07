import java.util.ArrayList;
import java.util.List;

public class ProgramInternalForm {
    private List<Pair<String, Pair<Integer, Integer>>> pif = new ArrayList<>();

    public void addToPif(String token, Pair<Integer, Integer> pos) {
        Pair<String, Pair<Integer, Integer>> pair = new Pair<>(token, pos);
        pif.add(pair);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Pair<String, Pair<Integer, Integer>> pair : pif) {
            result.append(pair.getPos()).append("->").append(pair.getSymbol().toString()).append("\n");
        }
        return result.toString();
    }
}
