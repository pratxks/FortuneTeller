import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class FortuneTellerViewer {
    public static void main(String[] args) throws IOException {
        FortuneTellerFrame MyFortuneTellerFrame = new FortuneTellerFrame();

        // make the frame 3/4 the height and width
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;

        int frameheight = (height * 3) / 4;
        int framewidth = (width * 3) / 4;

        MyFortuneTellerFrame.SetFrameStats();

        MyFortuneTellerFrame.setSize(framewidth, frameheight);

        MyFortuneTellerFrame.setResizable(false);

        // here's the part where i center the jframe on screen
        MyFortuneTellerFrame.setLocationRelativeTo(null);
        MyFortuneTellerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyFortuneTellerFrame.setVisible(true);
    }
}
