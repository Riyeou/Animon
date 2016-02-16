public class Moves {
    private String[] name;
    private int[] damage;
    
    public Moves(){
        name = new String[3];
        damage = new int[3];
    }
    
    public void setMoves(String type){
        switch (type) {
            case "Grass":
                name[0] = "Tackle";
                name[1] = "Vine Whip";
                name[2] = "Take Down";
                
                damage[0] = 50;
                damage[1] = 45;
                damage[2] = 90;
              
                break;
            case "Poison":
                name[0] = "Sting";
                name[1] = "Wrap";
                name[2] = "Bite";
               
                damage[0] = 15;
                damage[1] = 15;
                damage[2] = 60;
               
                break;
            case "Fire":
                name[0] = "Scratch";
                name[1] = "Ember";
                name[2] = "Fire Fang";
                damage[0] = 40;
                damage[1] = 40;
                damage[2] = 65;
                break;
            case "Water":
                name[0] = "Tackle";
                name[1] = "Water Gun";
                name[2] = "Bubble";
                
                damage[0] = 50;
                damage[1] = 40;
                damage[2] = 40;
        }
    }
    public int getMove(int choice){
        return damage[choice];
    }
    public String[] shareMoves(){
        return name;
    }
    
    public Moves giveMoves(){
        return this;
    }
    
   
}

