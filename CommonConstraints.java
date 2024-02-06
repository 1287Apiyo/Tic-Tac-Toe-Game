import java.awt.*;

public class CommonConstraints {
    //set config
    public static final Color BACKGROUND_COLOR=Color.decode("#011627");
    public static final Color x_COLOR=Color.decode("#E71036");
    public static final Color O_COLOR=Color.decode("#2EC486");
    public static final Color BAR_COLOR=Color.decode("#FF9F1C");
    public static final Color BOARD_COLOR=Color.decode("#FDFFFC");


    public  static final Dimension FRAME_SIZE=new Dimension(540,760);
    public static final Dimension BOARD_SIZE= new Dimension((int) (FRAME_SIZE.width * 0.96), (int) ((int) (FRAME_SIZE.height) * 0.60));
    public  static final Dimension BUTTON_SIZE=new Dimension(100,100);


    public static final String X_LABEL="X";
    public static final String O_LABEL="O";
    public static final String SCORE_LABEL="X : 0 | 0 : 0";




}
