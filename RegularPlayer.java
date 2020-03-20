
public class RegularPlayer extends Player{
    private Hand hand = new Hand();
    private int id;

    RegularPlayer(int id) {
        this.id = id;
    }

    void addCard(Card card) {
        hand.addCard(card, id);
    }

    Card layCardOnTable() {
        return hand.giveCard();
    }

    boolean isLose() {
        return hand.isLose();
    }

    int getPlayerId() {
        return id;
    }

    int getCardsCount() {
        return hand.getCardsCount();
    }

    Card showTopCard() {
        return hand.showTopCard();
    }

}