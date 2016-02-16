
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class TitleGUI extends JFrame implements ActionListener {

    private JButton button1, button2;
    private JLabel picLabel;

    public TitleGUI() {
        init();
    }

    public void init() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        button1 = new JButton();
        button2 = new JButton();
        button1.addActionListener(this);
        button2.addActionListener(this);
        button1.setBounds(200,120,100,30);
        button2.setBounds(200,175,100,30);
        button1.setText("1 Player");
        button2.setText("2 Players");
        this.add(button1);
        this.add(button2);
        BufferedImage backgroundPic = null;
        try {
            backgroundPic = ImageIO.read(new File("TitleScreen.png"));
        } catch (IOException ex) {
            Logger.getLogger(ScreenGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        picLabel = new JLabel(new ImageIcon(backgroundPic));
        picLabel.setSize(500, 300);
        this.pack();
        this.setSize(515, 335);
        this.add(picLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (button.equals(button1)) {
            ChoosePokeGUI choosePokeGUI = new ChoosePokeGUI(1);
        }

        if (button.equals(button2)) {
            ChoosePokeGUI choosePokeGUI = new ChoosePokeGUI(2);
        }
        this.setVisible(false);
    }
}
