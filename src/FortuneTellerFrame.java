import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    private Panel fortuneMainPanel;
    private Panel fortuneIconPanel;
    private Panel fortuneDisplayPanel;
    private Panel fortuneControlPanel;

    private ImageIcon fortuneTellerIcon;
    private JLabel fortuneTellerLabel;

    private JTextArea fortuneDisplayArea;
    private JScrollPane fortuneDisplayPane;

    private JButton fortuneReaderButton;
    private JButton fortuneTellerQuitButton;

    private ArrayList<String> fortuneStringArray;

    private Random readRandomFortune = new Random();

    private ArrayList<Integer> previousFortuneIndexArray = new ArrayList<Integer>();

    FortuneTellerFrame()
    {
        fortuneStringArray = new ArrayList<>();
        fortuneStringArray.add("A dubious friend may be an enemy in camouflage.");
        fortuneStringArray.add("A gambler not only will lose what he has, but also will lose what he doesn’t have.");
        fortuneStringArray.add("A golden egg of opportunity falls into your lap this month.");
        fortuneStringArray.add("A good time to finish up old tasks.");
        fortuneStringArray.add("A hunch is creativity trying to tell you something.");
        fortuneStringArray.add("A lifetime friend shall soon be made.");
        fortuneStringArray.add("A lifetime of happiness lies ahead of you.");
        fortuneStringArray.add("A new perspective will come with the new year.");
        fortuneStringArray.add("A pleasant surprise is waiting for you.");
        fortuneStringArray.add("A small donation is call for. It’s the right thing to do.");
        fortuneStringArray.add("All the effort you are making will ultimately pay off.");
        fortuneStringArray.add("All the troubles you have will pass away very quickly.");
        fortuneStringArray.add("All will go well with your new project.");
        fortuneStringArray.add("An acquaintance of the past will affect you in the near future.");
        fortuneStringArray.add("Any decision you have to make tomorrow is a good decision.");
    }

    public void SetFrameStats() throws IOException
    {
        fortuneMainPanel = new Panel();

        createFortuneHeaderPanel();
        createFortuneDisplayPanel();
        createFortuneControlPanel();

        fortuneMainPanel.setLayout(new BorderLayout());

        fortuneMainPanel.add(fortuneIconPanel, BorderLayout.NORTH);
        fortuneMainPanel.add(fortuneDisplayPanel, BorderLayout.CENTER);
        fortuneMainPanel.add(fortuneControlPanel, BorderLayout.SOUTH);

        add(fortuneMainPanel);
    }

    private void createFortuneHeaderPanel()
    {
        fortuneIconPanel = new Panel();

        Font headerLabelFont  = new Font(Font.MONOSPACED,  Font.BOLD, 36);

        fortuneTellerIcon = new ImageIcon("src/FortuneTeller1.jpg");
        fortuneTellerLabel = new JLabel("Fortune Teller", fortuneTellerIcon, JLabel.CENTER);
        fortuneTellerLabel.setFont(headerLabelFont);
        fortuneTellerLabel.setVerticalTextPosition(JLabel.BOTTOM);
        fortuneTellerLabel.setHorizontalTextPosition(JLabel.CENTER);

        fortuneIconPanel.add(fortuneTellerLabel);
    }

    private void createFortuneDisplayPanel()
    {
        fortuneDisplayPanel = new Panel();

        Font textAreaFont  = new Font(Font.SERIF,  Font.BOLD, 22);
        fortuneDisplayArea = new JTextArea(7, 50);
        fortuneDisplayArea.setFont(textAreaFont);
        fortuneDisplayArea.setEditable(false);
        fortuneDisplayPane = new JScrollPane(fortuneDisplayArea);
        fortuneDisplayPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        fortuneDisplayPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        fortuneDisplayPanel.add(fortuneDisplayPane);
    }

    private void createFortuneControlPanel()
    {
        fortuneControlPanel = new Panel();

        GridLayout fortuneControlLayout = new GridLayout(1,5);
        fortuneControlLayout.setHgap(10);
        fortuneControlLayout.setVgap(10);

        fortuneControlPanel.setLayout(fortuneControlLayout);

        Font buttonFont  = new Font(Font.SANS_SERIF,  Font.BOLD, 18);
        fortuneReaderButton = new JButton("Read My Fortune!");
        fortuneReaderButton.setFont(buttonFont);
		
        fortuneTellerQuitButton = new JButton("Quit");
        fortuneTellerQuitButton.setFont(buttonFont);

        JLabel emptyLabel1 = new JLabel("");
        JLabel emptyLabel2 = new JLabel("");
        JLabel emptyLabel3 = new JLabel("");

        fortuneControlPanel.add(emptyLabel1);
        fortuneControlPanel.add(fortuneReaderButton);
        fortuneControlPanel.add(emptyLabel3);
        fortuneControlPanel.add(fortuneTellerQuitButton);
        fortuneControlPanel.add(emptyLabel2);

        fortuneReaderButton.addActionListener(ae -> fortuneReaderButtonClick());

        fortuneTellerQuitButton.addActionListener(ae -> {
            System.exit(0);
        });
    }

    public void fortuneReaderButtonClick()
    {
        int iRandomFortuneIndex;

        if(previousFortuneIndexArray.size() == 15)
        {
            return;
        }

        do
        {
            iRandomFortuneIndex = readRandomFortune.nextInt(15);
        } while(previousFortuneIndexArray.contains(iRandomFortuneIndex));

        previousFortuneIndexArray.add(iRandomFortuneIndex);

        fortuneDisplayArea.append(fortuneStringArray.get(iRandomFortuneIndex) + "\n");
    }
}
