import java.util.*;

public class Poke {

    private double hp;
    private String name;
    private String type;
    private double damage;
    private int attack;
    private int defense;
    private double exp;
    private boolean evolved = false;
    private double doubleLvl;
    private int level;
    private boolean win;
    private int once = 0;
    private String[] moves;
   
    Moves move = new Moves();

    public Poke(String name, String type) {
        this.name = name;
        move.setMoves(type);
        this.moves = move.shareMoves();
        this.type = type;
       
        exp = 1;
        level = 1;
        win = false;
    }

    public String getName() {
        return name;
    }
    public boolean evolve(){
        return evolved;
    }
    public void evolveTrue(){
        evolved = true;
    }

    public String getType() {
        return type;
    }
    
    
    
    public void onceMore(){
        once++;
    }
    
    public int getOnce(){
        return once;
    }

    public double setStats(int level) {
        switch (this.type) {
            case "Grass":
                hp = (2 * 45 + 100) * level / 100 + 10;
                attack = (2 * 49 * level / 100) + 5;
                defense = (2 * 49 * level / 100) + 5;
                break;
            case "Poison":
                hp = (2 * 35 + 100) * level / 100 + 10;
                attack = (2 * 60 * level / 100) + 5;
                defense = (2 * 44 * level / 100) + 5;
                break;
            case "Fire":
                hp = (2 * 39 + 100) * level / 100 + 10;
                attack = (2 * 52 * level / 100) + 5;
                defense = (2 * 43 * level / 100) + 5;
                break;
            case "Water":
                hp = (2 * 44 + 100) * level / 100 + 10;
                attack = (2 * 48 * level / 100) + 5;
                defense = (2 * 65 * level / 100) + 5;
        }
        return hp;
    }

    public void setDamage(int n, String pType, String eType, int def, int atk, int level) {

//        setMultiplier(pType, eType);
//        generateRandom();
//        System.out.println("Def: " + def);
//        System.out.println("Atk: " + atk);
//        damage = (attack * move.getMove(n) / 50 / def + 2) * setMultiplier(pType, eType) * generateRandom() / 255;
        damage = ((0.4 * level + 2) * atk * move.getMove(n) / 50 / def + 2) * setMultiplier(pType, eType) * generateRandom() / 255;
       System.out.println("Damage: " + damage);
    }

    public double getDamage() {
        return damage;
    }

    public String getMoves(int n) {
        return moves[n];
    }
    
    public String[] shareMoves(){
        return moves;
    }

    public int getDef() {
        return defense;
    }

    public int getAtk() {
        return attack;
    }

    public int generateRandom() {
        int randumb;
        Random rand = new Random();
        randumb = rand.nextInt(255 - 217) + 217;
        return randumb;
    }

    public void levelUp() {
        
        doubleLvl = Math.cbrt(this.exp);
        
        level = (int) doubleLvl;
       

    }

    public int getLevel() {
        return level;
    }

    public void expGain(int level) {
        exp += 30 * level;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoves(String[] moves) {
        this.moves = moves;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    public double getExp(){
        return exp;
    }

    public boolean getWin() {
        return win;
    }

    public void win() {
        win = true;
    }

    public void winFalse() {
        win = false;
    }

    public double setMultiplier(String pType, String eType) {
        double multiplier;
        multiplier = 1;
        switch (pType) {
            case "Grass":
                switch (eType) {
                    case "Grass":
                        multiplier = 0.5;
                        break;
                    case "Fire":
                        multiplier = 0.5;
                        break;
                    case "Water":
                        multiplier = 2;
                        break;
                    case "Poison":
                        multiplier = 0.5;
                        break;
                }
                break;
            case "Fire":
                switch (eType) {
                    case "Grass":
                        multiplier = 2;
                        break;
                    case "Fire":
                        multiplier = 0.5;
                        break;
                    case "Water":
                        multiplier = 0.5;
                        break;
                    case "Poison":
                        multiplier = 1;
                        break;
                }
                break;
            case "Water":
                switch (eType) {
                    case "Grass":
                        multiplier = 0.5;
                        break;
                    case "Fire":
                        multiplier = 2;
                        break;
                    case "Water":
                        multiplier = 0.5;
                        break;
                    case "Poison":
                        multiplier = 1;
                        break;
                }
                break;
            case "Poison":
                switch (eType) {
                    case "Grass":
                        multiplier = 2;
                        break;
                    case "Fire":
                        multiplier = 1;
                        break;
                    case "Water":
                        multiplier = 1;
                        break;
                    case "Poison":
                        multiplier = 0.5;
                        break;
                }
                break;

        }

        return multiplier;

    }
}
