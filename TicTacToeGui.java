import javax.swing.*;
import java.awt.*;

public class TicTacToeGui extends JFrame {
    private JLabel turnLabel,scoreLabel;
    public TicTacToeGui(){
        super("Tic Tac Toe(Java Swing)");
        setSize(CommonConstraints.FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(CommonConstraints.BACKGROUND_COLOR);
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

        getContentPane().add(turnLabel);
         getContentPane().add(barLabel);
         getContentPane().add(scoreLabel);
    }
}
