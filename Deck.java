import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards = new ArrayList<Card>();
	// トランプカード53枚を作成する。
	public void setCards() {
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
		//　中身をシャッフル
		Collections.shuffle(this.cards);
	}
	
	// 	Deckからカードを削除。
	public void removeCard(int num) {
		cards.remove(num);
	}
	
	// デッキの枚数を所得。
	public int size() {
        return cards.size();
    }

	// 指定したデッキのカードの情報を取得
	public Card getCard(int num) {
		return cards.get(num);
	}
	
	// getterのみ設置で外部から変更できなくする。
	public List<Card> getCards() {
		return Collections.unmodifiableList(cards);

	}

}
