import java.util.List;
import java.util.Set;

public abstract class TicTacToeUser {
    private String name;
    private Set<Integer> playerPosition;
    private char symbol;

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public TicTacToeUser(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public Set<Integer> getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Set<Integer> playerPosition) {
        this.playerPosition = playerPosition;
    }

    public abstract int getPosition();
}
