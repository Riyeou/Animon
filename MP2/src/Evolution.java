public class Evolution extends Poke {
    private String name;
    private String type;
    private String status;
    private double damage;
    private double hp;
    private double atk;
    private double def;
    private double exp;
    private int level;
    private String[] move;
    eMoves moves = new eMoves();
    public Evolution(String name, String type){
        super(name,type);
        level = super.getLevel();
        this.type = type;
        super.setStats(level);
        move = moves.shareMoves();
        moves.setMoves(type);
       
    }
    
    public String getName(String type){
        switch(type){
        case "Grass":
        name = "Torterra";
        return name;
        case "Poison":
            name = "Weezing";
            return name;
        case "Fire":
            name = "Houndoom";
            return name;
        case "Water":
            name = "Kingler";
            return name;
    }
        return name;
    }
    
    
    
    
    public void setStatus(String type){
        switch(type){
        case "Poison":
        status = "Poisoned";
            break;
        case "Fire":
            status = "Burned";
            break;
    }
    }
    
    @Override
    public String[] shareMoves(){
        return move;
    }
   
    @Override
    public String getMoves(int n) {
        return move[n];
    }
    @Override
    public double getDamage() {
        return damage;
    }
    
    @Override
    public void setDamage(int n, String pType, String eType, int def, int atk, int level) {

//        setMultiplier(pType, eType);
//        generateRandom();
//        System.out.println("Def: " + def);
//        System.out.println("Atk: " + atk);
//        damage = (attack * move.getMove(n) / 50 / def + 2) * setMultiplier(pType, eType) * generateRandom() / 255;
        damage = ((0.4 * level + 2) * atk * moves.getMove(n) / 50 / def + 2) * setMultiplier(pType, eType) * generateRandom() / 255;
        System.out.println("Damage: " + damage);
    }
}
