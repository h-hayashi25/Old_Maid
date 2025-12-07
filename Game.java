
public class Game {
	void explain() {
		System.out.println("★☆★OLD MAIND★☆★");
		System.out.println("Computerと1対1でババ抜き");
		System.out.println("");
	}
	
	int order() {
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

	void deal(Deck deck, Player player, Computer computer) {
		System.out.println("--カードを配る--");
		// 0～1の乱数を作成し配る順番を決める。
		int r = new java.util.Random().nextInt(2); 
		do {
			int deckCards = deck.cards.size(); 
			// Playerから先に配る場合
			if(r == 0) { 
				// デッキカード総数未満の乱数を作成
				int r1 = new java.util.Random().nextInt(deckCards);
				// 乱数と同じ要素数のCardをPlayerの
				// 手札に足す。
				player.cards.add(deck.cards.get(r1));
				// Playerの手札に足したデッキのCardを削除
				deck.removeCard(r1);
				// デッキカード総数の更新
				deckCards = deck.cards.size();
				
				// デッキカードが1枚以上残っている場合
				if( deckCards > 0) {
					// デッキカード総数未満の乱数を作成
					r1 = new java.util.Random().nextInt(deckCards);
					// 乱数と同じ要素数のCardをComputerの
					// 手札に足す。
					computer.cards.add(deck.cards.get(r1));
					// Computerの手札に足したデッキのCardを削除
					deck.removeCard(r1);
				}
				
			// Computerから先に配る場合
			} else {
				// デッキカード総数未満の乱数を作成
				int r1 = new java.util.Random().nextInt(deckCards);
				// 乱数と同じ要素数のCardをcomputerの
				// 手札に足す。
				computer.cards.add(deck.cards.get(r1));
				// Computerの手札に足したデッキのCardを削除
				deck.removeCard(r1);
				// デッキカード総数の更新
				deckCards = deck.cards.size();
				if(deckCards > 0) {
					// デッキカード総数未満の乱数を作成
					r1 = new java.util.Random().nextInt(deckCards);
					// 乱数と同じ要素数のCardをPlayerの
					// 手札に足す。
					player.cards.add(deck.cards.get(r1));
					// Playerの手札に足したデッキのCardを削除
					deck.removeCard(r1);
				}
			}
		}while(deck.cards.size() > 0); // デッキのCardがなくなるまで繰り返す。
		System.out.println("あなたとComputerにカードを配りました。");
		player.showCards();
	}
	
	void play() {
		Game game = new Game(); // Gameインスタンス作成
		
		game.explain(); // 本アプリの説明をする。
		
		int order = game.order(); // 順番を決め、順番を格納
		
		Player player = new Player();// Playerインスタンス作成
		Computer computer = new Computer(); // Computerインスタンス作成
		Deck deal = new Deck();// Deckインスタンス作成
		
		game.deal(deal, player, computer); // カード分配
		player.Discard();	//Playerカード捨て
		computer.Discard(); //Computerカード捨て
		do {
			if(order == 0) { // Computer先攻の時
				// PlayerとComputerに手札がある時
				if(player.cards.size() > 0 && computer.cards.size() > 0) {
					computer.drawCard(player);	// Computerカード引く
					computer.Discard();			// Computerカード捨てる
				}
				// PlayerとComputerに手札がある時
				if(computer.cards.size() > 0 && player.cards.size() > 0 ) {
					player.drawCard(computer);	// Playerカード引く
					player.Discard();			// Playerカード捨てる
				}
			} else { // Player先攻の時
				// PlayerとComputerに手札がある時
				if(player.cards.size() > 0 && computer.cards.size() > 0) {
					player.drawCard(computer);	// Playerカード引く
					player.Discard();			// Playerカード捨てる
				}
				// PlayerとComputerに手札がある時
				if(player.cards.size() > 0 && computer.cards.size() > 0) {
					computer.drawCard(player);	// Computerカード引く
					computer.Discard();			// Computerカード捨てる
				}
			}
		} while(computer.cards.size() > 0 && player.cards.size() > 0);
		System.out.println("");
		System.out.println("--ゲーム結果--");
		if(computer.cards.size() == 0) {
			System.out.println("Computerの勝ち");
		}else if(player.cards.size() == 0) {
			System.out.println("あなたの勝ち");
		}
	}


}
