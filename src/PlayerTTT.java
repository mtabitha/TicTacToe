import java.util.Scanner;

public class PlayerTTT extends TicTacToeUser{
    private Scanner scanner = new Scanner(System.in);

    public PlayerTTT(String name) {
        super(name);
    }

    @Override
    public int getPosition() {
        return scanner.nextInt();
    }
}
