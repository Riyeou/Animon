
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ChoosePokeGUI extends JFrame implements ActionListener {

    private JComboBox list1, list2, list3, list4, list5, list6, list7, list8;
    private JButton button;
    private JLabel label1, label2;
    private ArrayList<Poke> Animons1, Animons2;
    int i;
    private JLabel picLabel;

    public ChoosePokeGUI(int i) {
        this.i = i;
        init();

    }

    public void init() {
        Animons1 = new ArrayList();
        Animons2 = new ArrayList();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        String[] pokes = {"Turtwig", "Koffing", "Houndour", "Krabby"};
        list1 = new JComboBox(pokes);
        list2 = new JComboBox(pokes);
        list3 = new JComboBox(pokes);
        list4 = new JComboBox(pokes);
        list1.setBounds(70, 60, 100, 30);
        this.add(list1);
        list2.setBounds(70, 110, 100, 30);
        this.add(list2);
        list3.setBounds(70, 160, 100, 30);
        this.add(list3);
        list4.setBounds(70, 210, 100, 30);
        this.add(list4);
        list5 = new JComboBox(pokes);
        list6 = new JComboBox(pokes);
        list7 = new JComboBox(pokes);
        list8 = new JComboBox(pokes);
        list5.setBounds(300, 60, 100, 30);
        this.add(list5);
        list6.setBounds(300, 110, 100, 30);
        this.add(list6);
        list7.setBounds(300, 160, 100, 30);
        this.add(list7);
        list8.setBounds(300, 210, 100, 30);
        this.add(list8);
        button = new JButton();
        button.setBounds(190, 120, 100, 30);
        this.add(button);
        button.addActionListener(this);
        button.setText("Save");
        label1 = new JLabel();
        label2 = new JLabel();
        label1.setText("Player 1");
        label2.setText("Player 2");
        label1.setBounds(70, 20, 100, 30);
        label2.setBounds(300, 20, 100, 30);
        this.add(label1);
        this.add(label2);
        if (this.i == 1) {
            list5.setEnabled(false);
            list6.setEnabled(false);
            list7.setEnabled(false);
            list8.setEnabled(false);
            list5.setSelectedIndex(2);
            list6.setSelectedIndex(1);
            list7.setSelectedIndex(3);
            list8.setSelectedIndex(0);
        }
        
        BufferedImage backgroundPic = null;
        try {
            backgroundPic = ImageIO.read(new File("Blue.png"));
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
    public void actionPerformed(ActionEvent ae) {
        Animons1.add(chooseP(list1.getSelectedIndex()+1));
        Animons1.add(chooseP(list2.getSelectedIndex()+1));
        Animons1.add(chooseP(list3.getSelectedIndex()+1));
        Animons1.add(chooseP(list4.getSelectedIndex()+1));
        if (this.i == 2) {
            Animons2.add(chooseP(list5.getSelectedIndex()+1));
            Animons2.add(chooseP(list6.getSelectedIndex()+1));
            Animons2.add(chooseP(list7.getSelectedIndex()+1));
            Animons2.add(chooseP(list8.getSelectedIndex()+1));
        } else if (this.i == 1) {
            Animons2.add(chooseP(3));
            Animons2.add(chooseP(2));
            Animons2.add(chooseP(4));
            Animons2.add(chooseP(1));
            for (Poke animon : Animons2) {
                for (int i = 0; i < 3; i++) {
                    animon.expGain(animon.getLevel());
                    animon.levelUp();
                }
            }
        }
        ScreenGUI screenGUI = new ScreenGUI(Animons1, Animons2, i);
        this.setVisible(false);
    }

    public Poke chooseP(int choice) {
        Poke p = null;
        switch (choice) {
            case 1:
                p = new Poke("Turtwig", "Grass");
                break;
            case 2:
                p = new Poke("Koffing", "Poison");
                break;
            case 3:
                p = new Poke("Houndour", "Fire");
                ;
                break;
            case 4:
                p = new Poke("Crabby", "Water");
                break;
        }

        return p;
    }
}
