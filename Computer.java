import java.util.ArrayList;
import java.util.List;

public class Computer implements Player{
	private List<Card> cards = new ArrayList<Card>();
	
	public void drawCard(Player human) {
		int humCards = human.size();
		if(humCards > 0 && this.cards.size() > 0) { // Humanの手札がある時
			// Humanの手札枚数未満の乱数を発生させて、引くカードを決める。
			int cardNumber = new java.util.Random().nextInt(humCards);
			// Humanの手札枚数未満の乱数を発生させて、引いたカードの挿入場所を決める。
			int addnubmer = new java.util.Random().nextInt(this.cards.size());
			// HumanのカードをComputerの手札に加える。
			this.addCard(addnubmer,human.getCard(cardNumber));
			// Humanの手札から引いたカードを削除
			human.removeCard(cardNumber);
			System.out.println("Computerがあなたの手札からカードを引きました。");
		} else { // Humanの手札が1枚もない時。
			System.out.println("あなたの手札が0枚またはComputerの手札が0枚のためゲームを終了します。");
		}
	}
	
	public void Discard(){
		int comCards = this.size();
		if(comCards > 1) {
			boolean removed;
			do {
				removed = false;
				a: for(int i = 0; i < comCards; i++) {
					for(int j = comCards - 1; j > i; j--) {
						// 2枚のCardが等価の時、カードを捨てる。
						if(this.getCard(i).equals(this.getCard(j))) {
							this.removeCard(j);
							this.removeCard(i);
							comCards = this.size();	// カード総数を更新
							System.out.println("Computerがカードを1組捨てました。");
							removed = true;
							break a; // aのループを抜ける。
						}
					}
				}
			}while(removed); // iがカードの最後の番号まで到達したら終了
			System.out.println("Computerの手札捨てが終了しました。");
		} else {
			System.out.println("Computerの手札が1枚以下のため手札を捨てれません。");
		}
	}
	
	public void showCards(){
		System.out.print("Computerの手札：");
		for(int i = 0; i < this.size(); i++) {
			System.out.print(" ? ");
		}
		System.out.println("");
	}
	
	// 手札を捨てる時または相手に引かれる時の処理
	public void removeCard(int num) {
		cards.remove(num);
	}
		
	// 手札にカードを加えるときの処理
	public void addCard(int num,Card card) {
		cards.add(num, card);
	}
		
	public void addCard(Card card) {
		cards.add(card);
	}
	// 指定した手札の情報を取得
	public Card getCard(int num) {
		return cards.get(num);
	}
	// 手札の枚数を所得。
	public int size() {
	   return cards.size();
	}
	
	// getterのみ設置で外部から変更できないようにする。
	public List<Card> getCards() {
		return java.util.Collections.unmodifiableList(cards);

	}
}
