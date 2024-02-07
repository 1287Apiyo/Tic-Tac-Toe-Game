import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TicTacToeGui extends JFrame implements ActionListener {
    private int xScore, oScore, moveCounter;

    //isPlayerOne - flag to indicate if the current player is player x or not
    private boolean isPlayerOne;
    private JLabel turnLabel, scoreLabel,resultLabel;
    private JButton[][] board;
    private JDialog resultDialog;


    public TicTacToeGui() {
        super("Tic Tac Toe(Java Swing)");
        setSize(CommonConstraints.FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(CommonConstraints.BACKGROUND_COLOR);
        //init vars
        createResultDialog();
        board = new JButton[3][3];
        //player x starts first
        isPlayerOne = true;
        addGuiComponents();
    }

    private void addGuiComponents() {
        //bar label
        JLabel barLabel = new JLabel();
        barLabel.setOpaque(true);
        barLabel.setBackground(CommonConstraints.BAR_COLOR);
        barLabel.setBounds(0, 0, CommonConstraints.FRAME_SIZE.width, 25);
        //turn label
        turnLabel = new JLabel(CommonConstraints.X_LABEL);
        turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        turnLabel.setFont(new Font("Dialog", Font.PLAIN, 40));
        turnLabel.setPreferredSize(new Dimension(100, turnLabel.getPreferredSize().height));
        turnLabel.setOpaque(true);
        turnLabel.setBackground(CommonConstraints.x_COLOR);
        turnLabel.setForeground(CommonConstraints.BOARD_COLOR);
        turnLabel.setBounds((CommonConstraints.FRAME_SIZE.width - turnLabel.getPreferredSize().width) / 2, 0, turnLabel.getPreferredSize().width,
                turnLabel.getPreferredSize().height
        );
        //score label
        scoreLabel = new JLabel(CommonConstraints.SCORE_LABEL);
        scoreLabel.setFont(new Font("Dialog", Font.PLAIN, 40));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setForeground(CommonConstraints.BOARD_COLOR);
        scoreLabel.setBounds(0, turnLabel.getY() + turnLabel.getPreferredSize().height + 25,
                CommonConstraints.FRAME_SIZE.width,
                scoreLabel.getPreferredSize().height
        );

        //game board
        GridLayout gridLayout = new GridLayout(3, 3);
        JPanel boardPanel = new JPanel(gridLayout);
        boardPanel.setBounds(0, scoreLabel.getY() + scoreLabel.getPreferredSize().height + 35,
                CommonConstraints.BOARD_SIZE.width,
                CommonConstraints.BOARD_SIZE.height
        );
//create board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                JButton button = new JButton();
                button.setFont(new Font("Dialog", Font.PLAIN, 180));
                button.setPreferredSize(CommonConstraints.BUTTON_SIZE);
                button.setBackground(CommonConstraints.BACKGROUND_COLOR);
                button.addActionListener(this);
                button.setBorder(BorderFactory.createLineBorder(CommonConstraints.BOARD_COLOR));

                //add buttons to  board
                board[i][j] = button;
                boardPanel.add(board[i][j]);

            }
        }


        //reset button
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Dialog", Font.PLAIN, 24));
        resetButton.addActionListener(this);
        resetButton.setBackground(CommonConstraints.BOARD_COLOR);
        resetButton.setBounds(
                (CommonConstraints.FRAME_SIZE.width - resetButton.getPreferredSize().width) / 2,
                CommonConstraints.FRAME_SIZE.height - 100,
                resetButton.getPreferredSize().width,
                resetButton.getPreferredSize().height

        );

        getContentPane().add(turnLabel);
        getContentPane().add(barLabel);
        getContentPane().add(scoreLabel);
        getContentPane().add(boardPanel);
        getContentPane().add(resetButton);
    }
    private void createResultDialog(){
        resultDialog=new JDialog();
        resultDialog.getContentPane().setBackground(CommonConstraints.BACKGROUND_COLOR);
        resultDialog.setResizable(false);
        resultDialog.setTitle("Result");
        resultDialog.setSize(CommonConstraints.RESULT_DIALOG_SIZE);
        resultDialog.setLocationRelativeTo(null);
        resultDialog.setModal(true);
        resultDialog.setLayout(new GridLayout(2,1));
        resultDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               resetGame();
            }
        });
      //result label
        resultLabel=new JLabel();
        resultLabel.setFont(new Font("Dialog",Font.BOLD,18));
        resultLabel.setForeground(CommonConstraints.BOARD_COLOR);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //restart button
        JButton restartButton=new JButton("Play Again");
        restartButton.setBackground(CommonConstraints.BOARD_COLOR);
        restartButton.addActionListener(this);

        resultDialog.add(resultLabel);
        resultDialog.add(restartButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Reset") || command.equals("Play Again") ) {
            //reset the game
            resetGame();
            //only reset the score when  pressing reset
            if (command.equals("Reset"))
                xScore=oScore=0;
            if (command.equals("Play Again"))
                resultDialog.setVisible(false);
        } else {
            //player move
            JButton button = (JButton) e.getSource();
            if (button.getText().equals(" ")) {
                moveCounter++;

                if (isPlayerOne) {
                    //player 1 x player
                    button.setText(CommonConstraints.X_LABEL);
                    button.setForeground(CommonConstraints.x_COLOR);

                    //update turn label
                    turnLabel.setText(CommonConstraints.O_LABEL);
                    turnLabel.setForeground(CommonConstraints.O_COLOR);

                    //update turn
                    isPlayerOne = false;

                } else {
                    //player two(o player)
                    button.setText(CommonConstraints.O_LABEL);
                    button.setForeground(CommonConstraints.O_COLOR);
                    //update turn label
                    turnLabel.setText(CommonConstraints.X_LABEL);
                    turnLabel.setForeground(CommonConstraints.x_COLOR);
                    //update turn
                    isPlayerOne = true;

                }
                //check the win conditions
                if (isPlayerOne){
                    //check to see whether the last move from 0 was the winning move
                    checkXWin();
                }{
                    //check to see if the las winning move was from X
                  checkOWin();
                }
            }
            repaint();
            revalidate();
        }


    }
    private void checkXWin() {
        String result = "X wins!";
        //check rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0].getText().equals("X") && board[row][1].getText().equals("X") && board[row][2].getText().equals("X")) {
                resultLabel.setText(result);

                //display result dialog
                resultDialog.setVisible(true);
                //update score
                xScore++;
            }
        }
        //check columns
        for (int col = 0; col < board.length; col++) {
            if (board[0][col].getText().equals("X") && board[1][col].getText().equals("X") && board[2][col].getText().equals("X")) {
                resultLabel.setText(result);

                //display result dialog
                resultDialog.setVisible(true);
                //update score
                xScore++;
            }
        }
        //check diagonals
        if (board[0][0].getText().equals("X") && board[1][1].getText().equals("X") && board[2][2].getText().equals("X")) {
            resultLabel.setText(result);

            //display result dialog
            resultDialog.setVisible(true);
            //update score
            xScore++;
        }
        if (board[2][0].getText().equals("X") && board[1][1].getText().equals("X") && board[0][2].getText().equals("X")){
            resultLabel.setText(result);

            //display result dialog
            resultDialog.setVisible(true);
            //update score
            xScore++;
        }
    }
    private void checkOWin(){
        String result = "O wins!";
        //check rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0].getText().equals("O") && board[row][1].getText().equals("O") && board[row][2].getText().equals("0")) {
                resultLabel.setText(result);

                //display result dialog
                resultDialog.setVisible(true);
                //update score
                oScore++;
            }
        }
        //check columns
        for (int col = 0; col < board.length; col++) {
            if (board[0][col].getText().equals("O") && board[1][col].getText().equals("O") && board[2][col].getText().equals("O")) {
                resultLabel.setText(result);

                //display result dialog
                resultDialog.setVisible(true);
                //update score
                oScore++;
            }
        }
        //check diagonals
        if (board[0][0].getText().equals("O") && board[1][1].getText().equals("O") && board[2][2].getText().equals("O")) {
            resultLabel.setText(result);

            //display result dialog
            resultDialog.setVisible(true);
            //update score
            oScore++;
        }
        if (board[2][0].getText().equals("O") && board[1][1].getText().equals("O") && board[0][2].getText().equals("O")){
            resultLabel.setText(result);

            //display result dialog
            resultDialog.setVisible(true);
            //update score
            oScore++;
        }

    }
    private void resetGame() {
        //reset player back to x_player
        isPlayerOne = true;
        turnLabel.setText(CommonConstraints.X_LABEL);
        turnLabel.setBackground(CommonConstraints.x_COLOR);
        //reset score
        scoreLabel.setText(CommonConstraints.SCORE_LABEL);

        //reset board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j].setText(" ");
            }
        }
    }
}