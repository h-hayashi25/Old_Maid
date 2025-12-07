import java.util.LinkedList;
import java.util.List;

public class Computer {
	List<Card> cards = new LinkedList<Card>();
	
	public void removeCard(int num) {
		cards.remove(num);
	}
	
	void drawCard(Player player) {
		int plyCards = player.cards.size();
		if(plyCards > 0 && this.cards.size() > 0) { // Playerの手札がある時
			// Playerの手札枚数未満の乱数を発生させて、引くカードを決める。
			int cardNumber = new java.util.Random().nextInt(plyCards);
			// Playerの手札枚数未満の乱数を発生させて、引いたカードの挿入場所を決める。
			int addnubmer = new java.util.Random().nextInt(this.cards.size());
			// PlayerのカードをComputerの手札に加える。
			this.cards.add(addnubmer,player.cards.get(cardNumber));
			// Playerの手札から引いたカードを削除
			player.removeCard(cardNumber);
			System.out.println("Computerがあなたの手札からカードを引きました。");
		} else { // Playerの手札が1枚もない時。
			System.out.println("あなたの手札が0枚またはComputerの手札が0枚のためゲームを終了します。");
		}
	}
	
	void Discard(){
		int comCards = this.cards.size();
		if(comCards > 1) {
			boolean removed;
			do {
				removed = false;
				a: for(int i = 0; i < comCards; i++) {
					for(int j = comCards - 1; j > i; j--) {
						// 2枚のCardが等価の時、カードを捨てる。
						if(this.cards.get(i).equals(this.cards.get(j))) {
							this.removeCard(j);
							this.removeCard(i);
							comCards = this.cards.size();	// カード総数を更新
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
}
