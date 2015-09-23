package Model;

/**
 * Created by ilnurgazizov on 23.09.15.
 */
public class Cell {
    private int x;
    private int y;
    private Status status;

    public enum Status {
        DECK, WATER, BUFFER, DAMAGED_DECK, DAMAGED_WATER, DAMAGED_BUFFER;
    }

    public Cell(int x, int y, Status status) {
        this.x = x;
        this.y = y;
        this.setStatus(status);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

}
