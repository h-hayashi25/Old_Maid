
public class Card {
	private String suit;
	private String rank;
	
	public String getSuit() {
		return suit;
	}
	
	// setterで設定しようとしている値が妥当か検査
	public void setSuit(String suit) {
		if(suit.matches("[♥♦♠♣]{1}") || suit.equals("JOKER")){
			this.suit = suit;
		} else {
			throw new IllegalArgumentException("不正なマークです: " + suit);
		}
		
	}
	
	public String getRank() {
		return rank;
	}
	
	// setterで設定しようとしている値が妥当か検査
	public void setNumber(String rank) {
		if(rank.matches("[AJQK2-9]{1}") || rank.equals("10") || rank.equals("0")){
		this.rank = rank;
		} else {
			throw new IllegalArgumentException("不正な数字です: " + rank);
		}
	}
	
	// ババ抜きは数字で同じものとみるのでそのように設定
	public boolean getCard(Object o) {
		if(o instanceof Card card) {
			if(this.rank.equals(card.getRank())) {
				return true;
			}
		}
		return false;
	}
	
	// コンソールに表示する時の設定
	public String toString() {
		if("JOKER".equals(this.suit)) {
			return this.getSuit();
		} else {
			return this.getSuit() + this.getRank();
		}
		
	}
	
	// ババ抜きは数字で同じものとみるのでそのように設定
	public boolean equals(Object o) {
		if(o instanceof Card card) {
			if(this.rank.equals(card.getRank())) {
				return true;
			}
		}
		return false;
	}
	
	// ババ抜きは数字で同じものとみるのでそのように設定
	public int  hashCode() {
		return Integer.parseInt(this.rank);
	}
}
