import java.util.LinkedList;
import java.util.List;

public class Deck {
	List<Card> cards = new LinkedList<Card>();
	// コンストラクタでトランプカード53枚を作成。
	Deck() {
		for(int i = 0; i < 4; i++) {
			String suit = "";
			switch(i) {
			case 0: suit = "♥"; break;
			case 1: suit = "♦"; break;
			case 2: suit = "♠"; break;
			case 3: suit = "♣"; break;
			}
			for(int j = 1; j <= 13; j++) {
				Card card = new Card();
				card.setSuit(suit);
				switch(j) {
				case 1: card.setNumber("A"); break;
				case 11: card.setNumber("J"); break;
				case 12: card.setNumber("Q"); break;
				case 13: card.setNumber("K"); break;
				default: card.setNumber(String.valueOf(j));
				}
				cards.add(card);
			}
		}
		Card joker = new Card();
		joker.setSuit("JOKER");
		joker.setNumber("0");
		cards.add(joker);
	}
	
	// トランプカード53枚を作成しなおす。
	void setCards() {
		cards.clear();
		for(int i = 0; i < 4; i++) {
			String suit = "";
			switch(i) {
			case 0: suit = "♥"; break;
			case 1: suit = "♦"; break;
			case 2: suit = "♠"; break;
			case 3: suit = "♣"; break;
			}
			for(int j = 1; j <= 13; j++) {
				Card card = new Card();
				card.setSuit(suit);
				switch(j) {
				case 1: card.setNumber("A"); cards.add(card); break;
				case 11: card.setNumber("J"); cards.add(card); break;
				case 12: card.setNumber("Q"); cards.add(card); break;
				case 13: card.setNumber("K"); cards.add(card); break;
				default: card.setNumber(String.valueOf(j));
				}
			}
		}
		Card joker = new Card();
		joker.setSuit("JOKER");
		joker.setNumber("0");
		cards.add(joker);
	}
	
	// 	Deckからカードを削除。
	void removeCard(int num) {
		cards.remove(num);
	}
}
