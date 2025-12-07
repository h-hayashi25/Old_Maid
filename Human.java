import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Human implements Player{
	private List<Card> cards = new ArrayList<Card>();
	
	public void drawCard(Player computer) {
		System.out.println("--あなたがカードを引く--");
		int comCards = computer.size();
		int num;
		if(comCards > 0 && this.cards.size() > 0) {
			// Computerの手札の表示
			System.out.println
			("コンピューターの手札は" + comCards +"枚あります。");
			computer.showCards();
			
			do {
				// Computerから引く札の番号を入力
				System.out.println
				("左から何番目を引きますか？（1～"+ comCards +"を入力してください。)");
				num = new Scanner(System.in).nextInt();
				
				// 正しくない入力の時の対処
				if(num > comCards) {
					System.out.println("Computerの手札以上の番号です。");
				}else if(num <= 0) {
					System.out.println("0以下の数は入力しないでください。");}
				
			}while(num <= 0 || num > comCards);
			
			try {
				// Computerの手札をPlayerの手札に追加。
				this.cards.add(computer.getCard(num - 1));
				// Computerの手札から引いた手札を削除。
				computer.removeCard(num - 1);
				System.out.println("左から" + num + "番目の手札を引きました。");
				// 手札を表示する。
				showCards();
			}catch(RuntimeException e) {
				System.out.println("Computerの手札以上の番号のため、引けませんでした。");
			}
			
		// Computerの手札が1枚もない時。
		} else { 
			System.out.println("Computerの手札が0枚またはあなたの手札が0枚のためゲームを終了します。");
		}
	}
	
	public void Discard() {
		System.out.println("--あなたが手札を捨てる--");
		int humanCards = this.cards.size();
		// 手札を捨てる
		int num1; // 捨てる手札番号1
		int num2; // 捨てる手札番号2
		int flag1 = 9; // 手札捨てを行うかのフラグ
		int flag2 = 9; // 繰り返すかのどうかのフラグ
		// 手札捨てるか聞く
		System.out.print("手札を捨てますか？（Yes…1/No…9)");
		flag1 = new Scanner(System.in).nextInt();
		if(flag1 != 1) {
			System.out.println("手札を捨てを終了します。");
			return;
		}
		if(humanCards > 1) {
			do {
				// 捨てる手札の番号をキーボードから読み込む。
				System.out.println
				("捨てる手札を2枚入力してください。（[ ]内の1～"+ humanCards +"を入力)");
				System.out.print("１枚目：");
				num1 = new Scanner(System.in).nextInt();
				System.out.print("２枚目：");
				num2 = new Scanner(System.in).nextInt();
				
				// 正しくない入力の時の対処
				if(num1 > humanCards || num2 > humanCards) {
				System.out.println("※Computerの手札以上の番号です。"); continue;
				}else if(num1 <= 0 || num2 <= 0) {
					System.out.println("※0以下の数は入力しないでください。"); continue;
				}else if (num1 == num2){
					System.out.println("※同じカードを選んでいます。"); continue;
				}
				
				// 手札を捨てる。
				 // 2枚のカードが同じ数の時カードを捨てる。
				if(this.cards.get(num1 - 1).equals(this.cards.get(num2 - 1))) {
					if(num1 < num2) {
						this.removeCard(num2 - 1);
						this.removeCard(num1 - 1);
					} else {
						this.removeCard(num1 - 1);
						this.removeCard(num2 - 1);
					}
					System.out.println("[" + num1 + "]と[" + num2 + "]を捨てました。");
				}else { //  2枚のカードが違う場合メッセージをだす。
					System.out.println("※この組み合わせは番号が違うため捨てることが出来ません。");
				}
				
				
				// Humanのカード総数を更新。
				humanCards = this.cards.size();
				
				// 手札を見せる。
				showCards();
				
				if(humanCards > 1) {	// Humanの手札が1枚より多いとき
					// 繰り返しを聞く。
					System.out.print
					("カード捨てることを繰り返しますか？（Yes…1/No…9)");
					flag2 = new Scanner(System.in).nextInt();
				} else {	// Humanの手札が1枚以以下のとき
					flag2 = 9; // 手札捨てループを終了させる。
					System.out.println("※あなたの手札が1枚以下のため手札を捨てるのを終了します。");
				}
			}while(flag2 == 1);
		// Humanの手札がない時
		} else {
			System.out.println("※あなたの手札が1枚以下のため手札を捨てれません。");
		}
	}

	public void showCards() {
		System.out.println("あなたの手札：");
		int flag = 0; // 改行フラグ
		for(int i = 1; i <= this.cards.size(); i++) {
			
			// 手札番号とカードの文字列を格納
			String msg ="[" + i + "]" + this.getCard(i - 1);
			// 格納した文字列の書式を設定
			System.out.printf("%-10s", msg);
			if(i % 7 == 0) { // 7の倍数の時
				System.out.println(""); // 改行するため、
				flag = 0;	// 改行フラグをOFFにする。
			}else {	// 7の倍数以外の時
				flag = 1;// 改行フラグをONにする。
			}
			
		}
		if(flag == 1) {	// 改行フラグがONの時、
			System.out.println(""); // 改行する。
		}
	}
	// 手札を捨てる時または相手に引かれる時の処理
	public void removeCard(int num) {
		cards.remove(num);
	}
	
	// 手札にカードを加えるときの処理
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
