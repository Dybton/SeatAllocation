public class Party implements Comparable<Party> {
    private final int id;
    private final float votes;
    private int seats = 0;
    private float quotient;

    public Party(int id, int votes) {
        this.id = id;
        this.votes = votes;
        this.quotient = votes;
    }

    public int getId() {
        return id;
    }

    public void setQuotient() {
        this.quotient = this.votes / (1 + this.seats);
    }

    public void incrementSeats() {
        this.seats++;
    }

    public int getSeats() {
        return seats;
    }

    // Overrides the compareTo method, so it compares based on quotient
    @Override
    public int compareTo(Party that) {
        if (this.quotient >= that.quotient) {
            return 1;
        } else if (that.quotient >= this.quotient) {
            return -1;
        }
        return 0;
    }

}
