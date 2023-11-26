import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FiniteAutomata fa= new FiniteAutomata();
        fa.readFAFromFile("src/fa.in");
        showMenu();

        Scanner scanner = new Scanner(System.in);
        int opt= scanner.nextInt();
        while(opt!=0){
            switch (opt){
                case 1:
                    Analyzer analyzer = new Analyzer("src/p2.txt");
                    analyzer.analyze();
                    break;
                case 2:
                    System.out.println(fa.getStates());
                    break;
                case 3:
                    System.out.println(fa.getAlphabet());
                    break;
                case 4:
                    System.out.println(fa.getTransitions());
                    break;
                case 5:
                    System.out.println(fa.getInitialState());
                    break;
                case 6:
                    System.out.println(fa.getFinalStates());
                    break;
                case 7:
                    System.out.println("Enter the sequence: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String sequence = scanner1.nextLine();
                    System.out.println(fa.isAccepted(sequence));

                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            System.out.println();
            showMenu();
            opt= scanner.nextInt();
        }

    }

    private static void showMenu(){
        System.out.println("Choose one of the following options: ");
        System.out.println("1. Analyze a file");
        System.out.println("2. The set of states: ");
        System.out.println("3. The alphabet: ");
        System.out.println("4. The transitions: ");
        System.out.println("5. The initial state: ");
        System.out.println("6. The final states: ");
        System.out.println("7. Check if the given sequence is accepted by the FA: ");
        System.out.println("0. Exit");
        System.out.println("\nEnter option:");
    }

    }

