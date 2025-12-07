
public class Card {
	private String suit;
	private String number;
	
	public String getSuit() {
		return suit;
	}
	
	public void setSuit(String suit) {
		if(suit.matches("[♥♦♠♣]{1}") || suit.equals("JOKER")){
			this.suit = suit;
		} else {
			System.out.println("マークをセット出来ません。");
		}
		
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		if(number.matches("[AJQK023456789]{1}") || number.equals("10")){
		this.number = number;
		} else {
			System.out.println("数字をセット出来ません。");
		}
	}
	
	public boolean equals(Object o) {
		if(o instanceof Card card) {
			if(this.number.equals(card.getNumber())) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		if(this.suit.equals("JOKER")) {
			return this.getSuit();
		} else {
			return this.getSuit() + this.getNumber();
		}
		
	}
	
}
