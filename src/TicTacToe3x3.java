import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TicTacToe3x3 {
    private static char USER1 = 'X';
    private static char USER2 = 'O';
    private static List<Integer> topRow = Arrays.asList(1, 2, 3);
    private static List<Integer> midRow = Arrays.asList(4, 5, 6);
    private static List<Integer> botRow = Arrays.asList(7, 8, 9);
    private static List<Integer> leftCol =  Arrays.asList(1, 4, 7);
    private static List<Integer> midCol =   Arrays.asList(2, 5, 8);
    private static List<Integer> rightCol = Arrays.asList(3, 6, 9);
    private static List<Integer> cross1 = Arrays.asList(1, 5, 9);
    private static List<Integer> cross2 = Arrays.asList(3, 5, 7);
    private static List<List<Integer>> winnerList =
            Arrays.asList(topRow, midRow, botRow, leftCol, midCol, rightCol, cross1, cross2);

    private Set<Integer> player1Positions = new HashSet<>();
    private Set<Integer> player2Positions = new HashSet<>();

    private static char[][] gameBoard = {   {' ', '|', ' ', '|', ' '},
                                            {'-', '+', '-', '+', '-'},
                                            {' ', '|', ' ', '|', ' '},
                                            {'-', '+', '-', '+', '-'},
                                            {' ', '|', ' ', '|', ' '}};
    private TicTacToeUser player1;
    private TicTacToeUser player2;

    public TicTacToe3x3(TicTacToeUser player) {
        this.player1 = player;
        this.player1.setPlayerPosition(player1Positions);
        this.player1.setSymbol(USER1);
        this.player2 = new Computer("Computer");
        this.player2.setPlayerPosition(player2Positions);
        this.player2.setSymbol(USER2);
    }

    public TicTacToe3x3(TicTacToeUser player1, TicTacToeUser player2) {
        this.player1 = player1;
        this.player1.setPlayerPosition(player1Positions);
        this.player1.setSymbol(USER1);
        this.player2 = player2;
        this.player2.setPlayerPosition(player2Positions);
        this.player2.setSymbol(USER2);
    }

    public void start() {
        while (true) {
            if (playerTurn(player1))
                break ;
            printGameBoard();
            if (playerTurn(player2))
                break ;
            printGameBoard();
        }
        printGameBoard();
    }

    private boolean playerTurn(TicTacToeUser player) {
        int pos;
        while (true) {
            System.out.print("Player " + player.getName()+ ", please enter " + "position(1-9): ");
            pos = player.getPosition(); System.out.println(pos);
            if (validationPos(pos))
                break;
        }
        enterChar(pos, player);
        player.getPlayerPosition().add(pos);
        return checkWinner(player);
    }

    private boolean checkWinner(TicTacToeUser player) {
        for (List<Integer> l : winnerList) {
            if (player.getPlayerPosition().containsAll(l)) {
                System.out.println("Player with name: " + player.getName() + " won!");
                return true;
            }
        }
        if ((player1Positions.size() + player2Positions.size()) == 9) {
            System.out.println("!DRAW!");
            return true;
        }
        return false;
    }

    private boolean validationPos(int pos) {
        if (player1Positions.contains(pos) || player2Positions.contains(pos) ||
                pos < 1 || pos > 9)
            return false;
        return true;
    }

    private void enterChar(int placement, TicTacToeUser player) {
        switch (placement) {
            case 1:
                gameBoard[0][0] = player.getSymbol();
                break ;
            case 2:
                gameBoard[0][2] = player.getSymbol();
                break ;
            case 3:
                gameBoard[0][4] = player.getSymbol();
                break ;
            case 4:
                gameBoard[2][0] = player.getSymbol();
                break ;
            case 5:
                gameBoard[2][2] = player.getSymbol();
                break ;
            case 6:
                gameBoard[2][4] = player.getSymbol();
                break ;
            case 7:
                gameBoard[4][0] = player.getSymbol();
                break ;
            case 8:
                gameBoard[4][2] = player.getSymbol();
                break ;
            case 9:
                gameBoard[4][4] = player.getSymbol();
                break ;
        }
    }

    private class Computer extends TicTacToeUser {
        public Computer(String name) {
            super(name);
        }

        @Override
        public int getPosition() {
            return ThreadLocalRandom.current().nextInt(1, 10);
        }
    }


    public void printGameBoard() {
        System.out.println("----------------------------------------");
        for(char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
