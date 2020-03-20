
public abstract class Player{

    abstract void addCard(Card card);

    abstract Card layCardOnTable();

    abstract boolean isLose();

    abstract int getPlayerId();

    abstract int getCardsCount();

    abstract Card showTopCard();

}