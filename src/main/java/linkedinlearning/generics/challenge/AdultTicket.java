package linkedinlearning.generics.challenge;

public class AdultTicket extends Ticket {
    @Override
    public int getPrice() {
        return 10;
    }

    @Override
    public String toString() {
        return "Adult ticket";
    }

}
