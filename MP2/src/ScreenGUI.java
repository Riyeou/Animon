
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ScreenGUI extends JFrame implements KeyListener {

    private JLabel[] tile;
    private JLabel player, player2;
    private JLabel picLabel;
    private int i;
    private ArrayList<Poke> Animons1, Animons2;

    public ScreenGUI(ArrayList<Poke> Animons1, ArrayList<Poke> Animons2, int i) {
        this.i = i;
        init();
        int x = 0;
        this.Animons1 = Animons1;
        this.Animons2 = Animons2;
        startBGMusic();
    }

    public void init() {
        this.setSize(256, 678);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        this.setLayout(null);
        tile = new JLabel[600];
        for (int i = 0; i < 600; i++) {
            tile[i] = new JLabel();
            this.add(tile[i]);
        }
        int i = 0;
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 40; y++) {
                tile[i].setBounds(x * 16, y * 16, 20, 16);
//                tile[i].setText("" + i);
                i++;
            }
        }
        BufferedImage playerPic = null;
        try {
            playerPic = ImageIO.read(new File("Front.png"));
        } catch (IOException ex) {
            Logger.getLogger(ScreenGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        player = new JLabel(new ImageIcon(playerPic));
        player.setSize(15, 20);
        player.setLocation(tile[245].getLocation());
        this.add(player);

        BufferedImage playerPic2 = null;
        try {
            playerPic2 = ImageIO.read(new File("Front.png"));
        } catch (IOException ex) {
            Logger.getLogger(ScreenGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        player2 = new JLabel(new ImageIcon(playerPic2));
        player2.setSize(15, 20);
        player2.setLocation(tile[325].getLocation());
        this.add(player2);

        BufferedImage backgroundPic = null;
        try {
            backgroundPic = ImageIO.read(new File("TestMap.png"));
        } catch (IOException ex) {
            Logger.getLogger(ScreenGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        picLabel = new JLabel(new ImageIcon(backgroundPic));
        picLabel.setSize(240, 640);
        this.add(picLabel);

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            goUp(player);
            wildP(player);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            goDown(player);
            wildP(player);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            goLeft(player);
            wildP(player);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            goRight(player);
            wildP(player);
        }
        if (i == 2) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                goUp(player2);
                wildP(player2);
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                goDown(player2);
                wildP(player2);
            }
            if (e.getKeyCode() == KeyEvent.VK_A) {
                goLeft(player2);
                wildP(player2);
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                goRight(player2);
                wildP(player2);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Battle battle = new Battle(Animons1, Animons2, i);
            battle.getWinner();
        }

        if (e.getKeyCode() == KeyEvent.VK_Y) {
            for (Poke animon : Animons1) {
                System.out.println("" + animon.getName() + ":" + animon.getLevel());
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void startBGMusic() {
        try {
            URL url = new URL("file:Background.wav");
            AudioClip clip = Applet.newAudioClip(url);
            clip.loop();
        } catch (Exception error) {
            System.out.println("File Not Found");
            System.out.println(error);
        }
    }

    public void goUp(JLabel person) {
        int x = person.getX();
        int y = person.getY();
        person.setLocation(x, y - 16);

        if (person.getLocation().equals(tile[284].getLocation())) {
            person.setLocation(x, y);
        }
        if (person.getLocation().equals(tile[244].getLocation())) {
            person.setLocation(x, y);
        }
        if (person.getLocation().equals(tile[204].getLocation())) {
            person.setLocation(x, y);
        }
        if (person.getLocation().equals(tile[324].getLocation())) {
            person.setLocation(x, y);
        }
        if (person.getLocation().equals(tile[364].getLocation())) {
            person.setLocation(x, y);
        }

        for (int i = 1; i < 14; i++) {
            if (person.getLocation().equals(tile[i * 40].getLocation())) {
                person.setLocation(x, y);
            }
        }
        BufferedImage playerPic = null;
        try {
            playerPic = ImageIO.read(new File("Back.png"));
        } catch (IOException ex) {
            Logger.getLogger(ScreenGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        person.setIcon(new ImageIcon(playerPic));

    }

    public void goLeft(JLabel person) {
        int x = person.getX();
        int y = person.getY();
        person.setLocation(x - 16, y);
        BufferedImage playerPic = null;
        try {
            playerPic = ImageIO.read(new File("Left.png"));
        } catch (IOException ex) {
            Logger.getLogger(ScreenGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        person.setIcon(new ImageIcon(playerPic));

        if (person.getLocation().equals(tile[360].getLocation())) {
            person.setLocation(x, y);
        }
        if (person.getLocation().equals(tile[361].getLocation())) {
            person.setLocation(x, y);
        }
        if (person.getLocation().equals(tile[362].getLocation())) {
            person.setLocation(x, y);
        }
        if (person.getLocation().equals(tile[363].getLocation())) {
            person.setLocation(x, y);
        }
        if (person.getLocation().equals(tile[364].getLocation())) {
            person.setLocation(x, y);
        }
        for (int i = 1; i < 39; i++) {
            if (person.getLocation().equals(tile[i].getLocation())) {
                person.setLocation(x, y);
            }
        }

    }

    public void goDown(JLabel person) {
        int x = person.getX();
        int y = person.getY();
        person.setLocation(x, y + 16);

        for (int i = 1; i < 14; i++) {
            if (person.getLocation().equals(tile[39 + i * 40].getLocation())) {
                person.setLocation(x, y);
            }
        }

        BufferedImage playerPic = null;
        try {
            playerPic = ImageIO.read(new File("Front.png"));
        } catch (IOException ex) {
            Logger.getLogger(ScreenGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        person.setIcon(new ImageIcon(playerPic));

    }

    public void goRight(JLabel person) {
        int x = person.getX();
        int y = person.getY();
        person.setLocation(x + 16, y);
        if (person.getLocation().equals(tile[200].getLocation())) {
            person.setLocation(x, y);
        }
        if (person.getLocation().equals(tile[201].getLocation())) {
            person.setLocation(x, y);
        }
        if (person.getLocation().equals(tile[204].getLocation())) {
            person.setLocation(x, y);
        }
        if (person.getLocation().equals(tile[202].getLocation())) {
            person.setLocation(x, y);
        }
        if (person.getLocation().equals(tile[203].getLocation())) {
            person.setLocation(x, y);
        }
        for (int i = 1; i < 39; i++) {
            if (person.getLocation().equals(tile[560 + i].getLocation())) {
                person.setLocation(x, y);
            }
        }

        BufferedImage playerPic = null;
        try {
            playerPic = ImageIO.read(new File("Right.png"));
        } catch (IOException ex) {
            Logger.getLogger(ScreenGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        person.setIcon(new ImageIcon(playerPic));

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

    public int randomize() {
        Random rand = new Random();
        int num;
        num = 1 + (int) (Math.random() * ((15 - 1) + 1));
        return num;
    }

    public void wildP(JLabel person) {
        for (int i = 0; i < 9; i++) {
            if (person.getLocation().equals(tile[91 + i].getLocation())) {
                batW(person, 3);
            }
        }
        for (int i = 0; i < 9; i++) {
            if (person.getLocation().equals(tile[131 + i].getLocation())) {
                batW(person, 3);
            }
        }
        for (int i = 0; i < 9; i++) {
            if (person.getLocation().equals(tile[51 + i].getLocation())) {
                batW(person, 3);
            }
        }
        for (int i = 0; i < 9; i++) {
            if (person.getLocation().equals(tile[171 + i].getLocation())) {
                batW(person, 3);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (person.getLocation().equals(tile[71 + i].getLocation())) {
                batW(person, 4);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (person.getLocation().equals(tile[111 + i].getLocation())) {
                batW(person, 4);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (person.getLocation().equals(tile[151 + i].getLocation())) {
                batW(person, 4);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (person.getLocation().equals(tile[191 + i].getLocation())) {
                batW(person, 4);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (person.getLocation().equals(tile[423 + i].getLocation())) {
                batW(person, 1);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (person.getLocation().equals(tile[463 + i].getLocation())) {
                batW(person, 1);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (person.getLocation().equals(tile[503 + i].getLocation())) {
                batW(person, 1);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (person.getLocation().equals(tile[543 + i].getLocation())) {
                batW(person, 1);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (person.getLocation().equals(tile[406 + i].getLocation())) {
                batW(person, 2);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (person.getLocation().equals(tile[446 + i].getLocation())) {
                batW(person, 2);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (person.getLocation().equals(tile[486 + i].getLocation())) {
                batW(person, 2);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (person.getLocation().equals(tile[526 + i].getLocation())) {
                batW(person, 2);
            }
        }
    }

    public void batW(JLabel person, int i) {
        if (randomize() == 3) {
            ArrayList<Poke> Animon = new ArrayList();
            Animon.add(chooseP(i));
            if (person.equals(player)) {
                Battle battle = new Battle(Animons1, Animon, 1);
                battle.getWinner();
            }
            if (person.equals(player2)) {
                Battle battle = new Battle(Animons2, Animon, 1);
                battle.getWinner();
            }

        }
    }
}
