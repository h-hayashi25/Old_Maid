import java.util.List;

public interface Player {
	public abstract void drawCard(Player player);
	public abstract void Discard();
	public abstract void showCards();
	public abstract void removeCard(int num);
	public abstract void addCard(Card card);
	public abstract Card getCard(int num);
	public abstract int size();
	public abstract List<Card> getCards();
}
