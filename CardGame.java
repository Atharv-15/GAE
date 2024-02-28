import java.util.*;

class Card {
    String symbol;
    int number;

    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }
}

public class CardGame {
    public static void main(String[] args) {
        collectAndGroupCards();
    }

    // Function to collect and group cards
    private static void collectAndGroupCards() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number of Cards: ");
        int numCards = scanner.nextInt();
        Map<String, List<Card>> cardMap = new HashMap<>();

        for (int i = 1; i <= numCards; i++) {
            System.out.println("Enter card " + i + ":");
            String symbol = scanner.next().toLowerCase();
            int number = scanner.nextInt();

            // Creating a Card object
            Card card = new Card(symbol, number);

            // Adding the card to the map
            if (!cardMap.containsKey(symbol)) {
                cardMap.put(symbol, new ArrayList<>());
            }
            cardMap.get(symbol).add(card);
        }

        // Printing distinct symbols in alphabetical order
        List<String> distinctSymbols = new ArrayList<>(cardMap.keySet());
        Collections.sort(distinctSymbols);
        System.out.println("\nDistinct Symbols are: " + String.join(" ", distinctSymbols));

        // Printing details for each symbol
        for (String symbol : distinctSymbols) {
            System.out.println("\nCards in " + symbol.toUpperCase() + " Symbol");
            List<Card> cards = cardMap.get(symbol);
            int totalCards = cards.size();
            int totalSum = cards.stream().mapToInt(card -> card.number).sum();

            for (Card card : cards) {
                System.out.println(card.symbol + " " + card.number);
            }

            System.out.println("Number of cards : " + totalCards);
            System.out.println("Sum of Numbers : " + totalSum);
        }

        scanner.close();
    }
}
