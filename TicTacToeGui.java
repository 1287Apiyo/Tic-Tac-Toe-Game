import javax.swing.*;
import java.awt.*;

public class TicTacToeGui extends JFrame {
    private JLabel turnLabel,scoreLabel;
    private  JButton[][] board;
    public TicTacToeGui(){
        super("Tic Tac Toe(Java Swing)");
        setSize(CommonConstraints.FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(CommonConstraints.BACKGROUND_COLOR);
        //init vars
        board=new JButton[3][3];
        addGuiComponents();
    }
    private void addGuiComponents(){
        //bar label
        JLabel barLabel=new JLabel();
        barLabel.setOpaque(true);
        barLabel.setBackground(CommonConstraints.BAR_COLOR);
        barLabel.setBounds(0,0,CommonConstraints.FRAME_SIZE.width,25);
        //turn label
        turnLabel=new JLabel(CommonConstraints.X_LABEL);
        turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        turnLabel.setFont(new Font("Dialog",Font.PLAIN,40));
        turnLabel.setPreferredSize(new Dimension(100,turnLabel.getPreferredSize().height));
        turnLabel.setOpaque(true);
        turnLabel.setBackground(CommonConstraints.x_COLOR);
        turnLabel.setForeground(CommonConstraints.BOARD_COLOR);
        turnLabel.setBounds((CommonConstraints.FRAME_SIZE.width-turnLabel.getPreferredSize().width)/2,0,turnLabel.getPreferredSize().width,
                turnLabel.getPreferredSize().height
        );
        //score label
        scoreLabel = new JLabel(CommonConstraints.SCORE_LABEL);
        scoreLabel.setFont(new Font("Dialog",Font.PLAIN,40));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setForeground(CommonConstraints.BOARD_COLOR);
        scoreLabel.setBounds(0,turnLabel.getY() + turnLabel.getPreferredSize().height + 25,
                CommonConstraints.FRAME_SIZE.width,
                scoreLabel.getPreferredSize().height
                );

        //game board
        GridLayout gridLayout=new GridLayout(3,3);
        JPanel boardPanel=new JPanel(gridLayout);
        boardPanel.setBounds(0, scoreLabel.getY() + scoreLabel.getPreferredSize().height + 35,
                CommonConstraints.BOARD_SIZE.width,
                CommonConstraints.BOARD_SIZE.height
        );
//create board
for (int i =0;i< board.length;i++){
    for(int j=0;j< board[i].length;j++) {
        JButton button=new JButton();
        button.setFont(new Font("Dialog",Font.PLAIN,180));
        button.setPreferredSize(CommonConstraints.BUTTON_SIZE);
        button.setBackground(CommonConstraints.BACKGROUND_COLOR);
        button.setBorder(BorderFactory.createLineBorder(CommonConstraints.BOARD_COLOR));

        //add buttons to  board
        board[i][j]=button;
        boardPanel.add(board[i][j]);

    }
}

        getContentPane().add(turnLabel);
         getContentPane().add(barLabel);
         getContentPane().add(scoreLabel);
         getContentPane().add(boardPanel);
    }
}
