
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FiniteAutomata {
    public Set<String> alphabet, states, finalStates;
    public String initialState;
    public Map<Pair<String, String>, Set<String>> transitions;

    public FiniteAutomata() {
        this.states = new HashSet<>();
        this.alphabet = new HashSet<>();
        this.finalStates = new HashSet<>();
        this.transitions = new HashMap<>();

    }

    public Set<String> getStates() {
        return states;
    }

    public Set<String> getAlphabet() {
        return alphabet;
    }

    public Map<Pair<String, String>, Set<String>> getTransitions() {
        return transitions;
    }

    public String getInitialState() {
        return initialState;
    }

    public Set<String> getFinalStates() {
        return finalStates;
    }

    public void readFAFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);

            String statesLine = reader.nextLine();
            states = new HashSet<>(Arrays.asList(statesLine.split(" ")));

            String alphabetLine = reader.nextLine();
            alphabet = new HashSet<>(Arrays.asList(alphabetLine.split(" ")));

            initialState = reader.nextLine();

            String finalStatesLine = reader.nextLine();
            finalStates = new HashSet<>(Arrays.asList(finalStatesLine.split(" ")));

            processTransitions(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void processTransitions(Scanner reader) {
        while(reader.hasNextLine()) {
            String transitionLine = reader.nextLine();
            String[] transitionElements = transitionLine.split(" ");

            if(states.contains(transitionElements[0]) && states.contains(transitionElements[2]) && alphabet.contains(transitionElements[1])) {
                Pair<String, String> transitionState = new Pair<>(transitionElements[0], transitionElements[1]);

                if (!transitions.containsKey(transitionState)) {
                    Set<String> transitionStatesSet = new HashSet<>();
                    transitionStatesSet.add(transitionElements[2]);
                    transitions.put(transitionState, transitionStatesSet);
                } else {
                    transitions.get(transitionState).add(transitionElements[2]);
                }
            }
        }
    }

    public boolean checkIfDFA() {
        return transitions.values().stream().allMatch(list -> list.size() <= 1);}

    public boolean isAccepted(String sequence) {
        if(sequence.isEmpty()) {
            return finalStates.contains(initialState);
        }

        if (!checkIfDFA()) {
            System.out.println("The FA is not deterministic.");
            return false;
        }

        String state = initialState;
        for (char symbol : sequence.toCharArray()) {
            Pair<String, String> key = new Pair<>(state, String.valueOf(symbol));

            boolean match = false;
            for (Pair<String, String> pairKey : transitions.keySet()) {
                if (pairKey.getPos().equals(key.getPos()) && pairKey.getSymbol().equals(key.getSymbol())) {
                    match = true;
                    state = transitions.get(pairKey).iterator().next();
                    break;
                }
            }

            if (!match) {
                System.out.println("No transition for state " + state + " and symbol " + symbol);
                return false;
            }
        }
        return finalStates.contains(state);
    }


}