import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gamebryce extends Application {
    private Button[][] board = new Button[5][5];
    private boolean isXTurn = true;

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> resetBoard());

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Button btn = new Button();
                btn.setPrefSize(100, 100);
                int finalI = i;
                int finalJ = j;
                btn.setOnAction(e -> handleButtonClick(finalI, finalJ));
                board[i][j] = btn;
                grid.add(btn, j, i);
            }
        }

        VBox root = new VBox(10, grid, resetButton);
        Scene scene = new Scene(root, 500, 550);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void resetBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j].setText("");
            }
        }
        isXTurn = true; // Reset turn
    }

    private void handleButtonClick(int i, int j) {
        if (!board[i][j].getText().equals("")) {
            return; // Cell already occupied
        }

        board[i][j].setText(isXTurn ? "X" : "O");

        if (checkWinner(isXTurn ? "X" : "O")) {
            System.out.println("Player " + (isXTurn ? "X" : "O") + " wins!");
            // Disable further clicks on the board or call the resetBoard method
        } else if (isBoardFull()) {
            System.out.println("The game is a draw!");
            // Disable further clicks on the board or call the resetBoard method
        }

        isXTurn = !isXTurn;
    }

    private boolean checkWinner(String playerSymbol) {
        return isXTurn;
        // ... [Your existing code for checking winner]
    }

    private boolean checkLine(String symbol, Button... buttons) {
        return isXTurn;
        // ... [Your existing code for checking a line]
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}





