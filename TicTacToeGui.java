import javax.swing.*;
import java.awt.*;

public class TicTacToeGui extends JFrame {
    private JLabel turnLabel;
    public TicTacToeGui(){
        super("Tic Tac Toe(Java Swing)");
        setSize(CommonConstraints.FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
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
        turnLabel.setPreferredSize(new Dimension(100,turnLabel.getPreferredSize().height));
        turnLabel.setOpaque(true);
        turnLabel.setBackground(CommonConstraints.x_COLOR);
        turnLabel.setForeground(CommonConstraints.BOARD_COLOR);
        turnLabel.setBounds((CommonConstraints.FRAME_SIZE.width-turnLabel.getPreferredSize().width)/2,0,turnLabel.getPreferredSize().width,
                turnLabel.getPreferredSize().height
        );

         getContentPane().add(barLabel);
         getContentPane().add(turnLabel);
    }
}
