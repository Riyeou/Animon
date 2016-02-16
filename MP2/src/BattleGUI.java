//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.imageio.ImageIO;
//import javax.swing.*;
//
//public class BattleGUI extends JFrame implements ActionListener {
//
//    private ArrayList<Poke> Animons1, Animons2;
//    private int HorC;
//    private JLabel label, picLabel;
//    private JButton button1, button2, button3, button4;
//    private JTextField sequence;
//    private String output;
//    private int choice;
//
//    private String name1, name2, type1, type2;
//    private double p1Hp, p2Hp;
//    private int a1, a2, d1, d2;
//    int i;
//    private int choice1, choice2;
//    private int p1Cnt = 0;
//    private int p2Cnt = 0;
//    private String[] moves1, moves2;
//    private boolean press = false;
//
//    public BattleGUI(ArrayList Animons1, ArrayList Animons2, int HorC) {
//        init();
//        start();
//    }
//
//    public void init() {
//        this.setSize(515, 335);
//        this.setVisible(true);
////        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        this.setLayout(null);
//        sequence = new JTextField();
//        Animons1 = new ArrayList();
//        Animons2 = new ArrayList();
//        label = new JLabel();
//        button1 = new JButton();
//        button2 = new JButton();
//        button3 = new JButton();
//        button4 = new JButton();
//        this.add(button1);
//        this.add(button2);
//        this.add(button3);
//        this.add(button4);
//
//        sequence.setSize(500, 150);
//        sequence.setEnabled(false);
//        this.add(sequence);
//
//        button1.setBounds(70, 170, 100, 30);
//        button2.setBounds(70, 230, 100, 30);
//        button3.setBounds(200, 170, 100, 30);
//        button4.setBounds(200, 230, 100, 30);
//
//        BufferedImage backgroundPic = null;
//        try {
//            backgroundPic = ImageIO.read(new File("Blue.png"));
//        } catch (IOException ex) {
//            Logger.getLogger(ScreenGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        picLabel = new JLabel(new ImageIcon(backgroundPic));
//        picLabel.setSize(500, 300);
//        this.pack();
//        this.setSize(515, 335);
//        this.add(picLabel);
//        output = "";
//    }
//
//    public void start() {
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//
//    }
//
//    public void startBattle(int Player, Poke p) {
//        if (Player == 1) {
//            p.winFalse();
//
//            this.name1 = p.getName();
//            this.type1 = p.getType();
//            this.p1Hp = p.setStats(p.getLevel());
//            this.a1 = p.getAtk();
//            this.d1 = p.getDef();
//            this.moves1 = p.shareMoves();
//
//        } else if (Player == 2) {
//            p.winFalse();
//            this.name2 = p.getName();
//            this.type2 = p.getType();
//            this.p2Hp = p.setStats(p.getLevel());
//            this.a2 = p.getAtk();
//            this.d2 = p.getDef();
//            this.moves2 = p.shareMoves();
//        }
//    }
//
//    public void getWinner() {
//        startBattle(1, Animons1.get(p1Cnt));
//        startBattle(2, Animons2.get(p2Cnt));
//        while (p1Cnt < 4 && p2Cnt < 4) {
//            System.out.println(name1 + "'s turn");
//            sequence.setText(output);
//            System.out.println("What move will " + name1 + " use?");
//            sequence.setText(output);
//            for (i = 0; i < 3; i++) {
//                System.out.println("[" + i + "]" + Animons1.get(p1Cnt).getMoves(i));
//            }
//            choice1 = sc.nextInt();
//            Animons1.get(p1Cnt).setDamage(choice1, type1, type2, d2, a1, Animons1.get(p1Cnt).getLevel());
//            p2Hp -= Animons1.get(p1Cnt).getDamage();
//            if (p2Hp < 0) {
//                p2Hp = 0;
//            }
//            System.out.println(name2 + "'s turn");
//            if (HorC == 1) {
//                System.out.println("What move will " + name2 + " use?");
//                for (i = 0; i < 3; i++) {
//                    System.out.println("[" + i + "]" + Animons2.get(p2Cnt).getMoves(i));
//                }
//                choice1 = sc.nextInt();
//            } else if (HorC == 2) {
//
//                Random rand = new Random();
//                choice2 = rand.nextInt() % 2 + 1;
//                System.out.println("Choice = " + choice2);
//            }
//            Animons2.get(p2Cnt).setDamage(choice2, type2, type1, d1, a2, Animons2.get(p2Cnt).getLevel());
//            p1Hp -= Animons2.get(p2Cnt).getDamage();
//            if (p1Hp < 0) {
//                p1Hp = 0;
//            }
//
//            System.out.println("Player 1's " + name1 + "'s remaining HP: " + p1Hp);
//            System.out.println("Player 2's " + name2 + "'s remaining HP: " + p2Hp);
//            if (p1Hp <= 0) {
//                System.out.println("Player 1's " + name1 + " has fainted!");
//                p1Cnt++;
//                Animons2.get(p2Cnt).win();
//                if (Animons2.get(p2Cnt).getWin() == true) {
//                    Animons2.get(p2Cnt).expGain(Animons2.get(p2Cnt).getLevel());
//                    Animons2.get(p2Cnt).levelUp();
//                    System.out.println(name2 + " " + "levels Up!");
//                    System.out.println(name2 + "'s exp: " + Animons2.get(p2Cnt).getExp());
//                    System.out.println(name2 + "'s current level: " + Animons2.get(p2Cnt).getLevel());
//                    if (Animons2.get(p2Cnt).getLevel() >= 16) {
//                        Animons2.get(p2Cnt).evolveTrue();
//                        Animons2.get(p2Cnt).onceMore();
//                        if (Animons2.get(p2Cnt).evolve() == true && Animons2.get(p2Cnt).getOnce() <= 1) {
//                            Evolution evo2 = new Evolution(Animons2.get(p2Cnt).getName(), Animons2.get(p2Cnt).getType());
//                            Animons2.set(p2Cnt, evo2);
//                            Animons2.get(p2Cnt).setName(evo2.getName(Animons2.get(p2Cnt).getType()));
//                            Animons2.get(p2Cnt).setMoves(evo2.shareMoves());
//                            Animons2.get(p2Cnt).setExp(4171);
//                            Animons2.get(p2Cnt).setLevel(16);
//                            name2 = evo2.getName(Animons2.get(p2Cnt).getType());
//                            moves2 = evo2.shareMoves();
//                            System.out.println("Congratulations! Your animon has evolved into " + evo2.getName(Animons2.get(p2Cnt).getType()));
//                            Animons2.get(p2Cnt).onceMore();
//                        }
//                    }
//                }
//                if (p1Cnt != Animons1.size()) {
//                    startBattle(1, Animons1.get(p1Cnt));
//                }
//            } else if (p2Hp <= 0) {
//                System.out.println("Player 2's " + name2 + " has fainted!");
//                p2Cnt++;
//                Animons1.get(p1Cnt).win();
//                if (Animons1.get(p1Cnt).getWin() == true) {
//                    Animons1.get(p1Cnt).expGain(Animons1.get(p1Cnt).getLevel());
//                    Animons1.get(p1Cnt).levelUp();
//                    System.out.println(name1 + " " + "levels Up!");
//                    System.out.println(name1 + "'s exp: " + Animons1.get(p1Cnt).getExp());
//                    System.out.println(name1 + "'s current level: " + Animons1.get(p1Cnt).getLevel());
//                    if (Animons1.get(p1Cnt).getLevel() >= 16) {
//                        Animons1.get(p1Cnt).evolveTrue();
//                        Animons1.get(p1Cnt).onceMore();
//                        if (Animons1.get(p1Cnt).evolve() == true && Animons1.get(p1Cnt).getOnce() <= 1) {
//                            Evolution evo1 = new Evolution(Animons1.get(p1Cnt).getName(), Animons1.get(p1Cnt).getType());
//                            Animons1.set(p1Cnt, evo1);
//                            Animons1.get(p1Cnt).setName(evo1.getName(Animons1.get(p1Cnt).getType()));
//                            Animons1.get(p1Cnt).setMoves(evo1.shareMoves());
//                            Animons1.get(p1Cnt).setExp(4171);
//                            Animons1.get(p1Cnt).setLevel(16);
//                            name1 = evo1.getName(Animons1.get(p1Cnt).getType());
//                            moves1 = evo1.shareMoves();
//                            System.out.println("Congratulations! Your animon has evolved into " + evo1.getName(Animons1.get(p1Cnt).getType()));
//                            Animons1.get(p1Cnt).onceMore();
//                        }
//                    }
//                }
//                if (p2Cnt != Animons2.size()) {
//                    startBattle(2, Animons2.get(p2Cnt));
//                }
//            }
//
//        }
//        if (p1Cnt == Animons1.size()) {
//            System.out.println("Player 2 wins!");
//        } else if (p2Cnt == Animons2.size()) {
//            System.out.println("Player 1 wins!");
//        }
//    }
//
//}
