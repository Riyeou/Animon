public class eMoves extends Moves {

    private String[] name;
    private int[] damage;

    public eMoves() {
        name = new String[4];
        damage = new int[4];
    }

    @Override
    public void setMoves(String type) {
        switch (type) {
            case "Grass":
                name[0] = "Take Down";
                name[1] = "Vine Whip";
                name[2] = "Solar Beam";

                damage[0] = 90;
                damage[1] = 45;
                damage[2] = 120;
                
                break;
            case "Poison":
                name[0] = "Sting";
                name[1] = "Constrict";
                name[2] = "Sludge Bomb";
                
                damage[0] = 15;
                damage[1] = 20;
                damage[2] = 90;
                
                break;
            case "Fire":
                name[0] = "Scratch";
                name[1] = "Flamethrower";
                name[2] = "Fire Blast";
                
                damage[0] = 40;
                damage[1] = 90;
                damage[2] = 110;
                break;
            case "Water":
                name[0] = "Tackle";
                name[1] = "Scald";
                name[2] = "Hydro Pump";
             
                damage[0] = 50;
                damage[1] = 40;
                damage[2] = 120;
                
        }
    }
    
    @Override
    public int getMove(int choice){
        return damage[choice];
    }
    
    @Override
    public String[] shareMoves(){
        return name;
    }
}
