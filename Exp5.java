import java.util.HashSet;
import java.util.Set;

class Card {
    private String symbol;

    public Card(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    // Override equals and hashCode for proper HashSet functionality
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return symbol.equals(card.symbol);
    }

    @Override
    public int hashCode() {
        return symbol.hashCode();
    }
}

public class Exp5 {
    public static void main(String[] args) {
        Set<Card> uniqueSymbolsSet = new HashSet<>();

        // Adding cards to the set
        uniqueSymbolsSet.add(new Card("Heart"));
        uniqueSymbolsSet.add(new Card("Diamond"));
        uniqueSymbolsSet.add(new Card("Spade"));
        uniqueSymbolsSet.add(new Card("Club"));

        Card duplicateCard = new Card("Heart");
        if (uniqueSymbolsSet.add(duplicateCard)) {
            System.out.println(duplicateCard.getSymbol() + " added successfully.");
        } else {
            System.out.println(duplicateCard.getSymbol() + " is a duplicate and won't be added.");
        }

        // Displaying unique symbols
        System.out.println("Unique Symbols in the set:");
        for (Card card : uniqueSymbolsSet) {
            System.out.println(card.getSymbol());
        }
    }
}
