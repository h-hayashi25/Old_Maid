
public class Game {
	// ゲームの説明
	public void explain() {
		System.out.println("★☆★OLD MAIND★☆★");
		System.out.println("Computerと1対1でババ抜き");
		System.out.println("");
	}
	
	// 順番決め
	public int order() {
		char[] coin = {'裏', '表'};
		String[] orderStr = {"Computer", "あなた"};
		System.out.println("--順番決め--");
		System.out.println("コインを投げます。");
		System.out.println("裏：Computer、表：あなた");
		int r = new java.util.Random().nextInt(coin.length);
		System.out.println
		( coin[r] + "のため、" + orderStr[r] + "が先攻！");
		System.out.println("");
		return r;
		
	}
	
	// カードを配る
	public void deal(Deck deck, Player human, Player computer) {
		System.out.println("--カードを配る--");
		// 0～1の乱数を作成し配る順番を決める。
		int r = new java.util.Random().nextInt(2); 
		do {
			int deckCards = deck.size(); 
			// Humanから先に配る場合
			if(r == 0) { 
				// デッキの1枚目を手札に足す。
				human.addCard(deck.getCard(0));
				// Humanの手札に足したデッキのCardを削除
				deck.removeCard(0);
				// デッキカード総数の更新
				deckCards = deck.size();
				
				// デッキカードが1枚以上残っている場合
				if( deckCards > 0) {
					// デッキの1枚目を手札に足す。
					computer.addCard(deck.getCard(0));
					// Computerの手札に足したデッキのCardを削除
					deck.removeCard(0);
				}
				
			// Computerから先に配る場合
			} else {
				// デッキの1枚目を手札に足す。
				computer.addCard(deck.getCard(0));
				// Computerの手札に足したデッキのCardを削除
				deck.removeCard(0);
				// デッキカード総数の更新
				deckCards = deck.size();
				if(deckCards > 0) {
					// デッキの1枚目を手札に足す。
					human.addCard(deck.getCard(0));
					// Humanの手札に足したデッキのCardを削除
					deck.removeCard(0);
				}
			}
		}while(deck.size() > 0); // デッキのCardがなくなるまで繰り返す。
		System.out.println("あなたとComputerにカードを配りました。");
		human.showCards();
	}
	
	// ゲームプレイ
	public void play() {
		
		this.explain(); // 本アプリの説明をする。
		
		int order = this.order(); // 順番を決め、順番を格納
		
		Human human = new Human();// Humanインスタンス作成
		Computer computer = new Computer(); // Computerインスタンス作成
		Deck deck = new Deck();// Deckインスタンス作成
		deck.setCards(); // Deckのカードを生成
		
		this.deal(deck, human, computer); // カード分配
		human.Discard();	// Humanカード捨て
		computer.Discard(); // Computerカード捨て
		do {
			if(order == 0) { // Computer先攻の時
				// HumanとComputerに手札がある時
				if(human.size() > 0 && computer.size() > 0) {
					computer.drawCard(human);	// Computerカード引く
					computer.Discard();			// Computerカード捨てる
				}
				// HumanとComputerに手札がある時
				if(computer.size() > 0 && human.size() > 0 ) {
					human.drawCard(computer);	// Humanカード引く
					human.Discard();			// Humanカード捨てる
				}
			} else { // Human先攻の時
				// HumanとComputerに手札がある時
				if(human.size() > 0 && computer.size() > 0) {
					human.drawCard(computer);	// Humanカード引く
					human.Discard();			// Humanカード捨てる
				}
				// HumanとComputerに手札がある時
				if(human.size() > 0 && computer.size() > 0) {
					computer.drawCard(human);	// Computerカード引く
					computer.Discard();			// Computerカード捨てる
				}
			}
		} while(computer.size() > 0 && human.size() > 0);
		System.out.println("");
		System.out.println("--ゲーム結果--");
		if(computer.size() == 0) {
			System.out.println("Computerの勝ち");
		}else if(human.size() == 0) {
			System.out.println("あなたの勝ち");
		}
	}


}
