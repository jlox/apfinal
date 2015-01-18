public abstract class pokemon {
    private int health;
    private int strength;
    private int defense;
    private int speed;
    private boolean defending;
    private int attackStrength;
    private String name;
    private String type;
    private String species;

    public String toString(){
	return name;
    }

    public String getType(){
	return type;
    }

    public void setType(String n){
	type = n;
    }

    public String getSpecies(){
	return species;
    }

    public void setSpecies(String n){
	species = n;
    }

    public void assignDamage(pokemon other){
	int AT = this.getAttackStrength();
	other.lowerHealth(AT);
    }

    public int getAttackStrength(){
	return attackStrength;
    }
    public void setAttackStrength(int s){
	attackStrength = s;
    }
    public void lowerAttackStrength(int l){
	if (attackStrength - l < 0) {
	    attackStrength = 1;
	}
	else
	    {
		attackStrength = attackStrength - l;
	    }
    }
    public void setDefending (boolean b){
	defending = b;
    }
    public boolean getDefending () {
	return defending;
    }
    public void setSpeed (int s){
	speed = s;
    }
    public int getSpeed (){
	return speed;
    }
	
    public void setHealth(int h){
	health=h;
    }
    public int getHealth(){
	return health;
    }
    public void lowerHealth(int l){
	health = health - l;
	if (health < 0){
	    health = 0;
	}
    }
    public void increaseHealth(int i){
	health = health + i;
    }
    public void setStrength(int s){
	strength=s;
    }
    public int getStrength(){
	return strength;
    }

    public void setName(String n){
	name = n;
    }
    public String getName(){
	return name;
    }
    
    

    public void pause(int t){
	try {
	    Thread.sleep(t);
	} catch (Exception e) {}
    }
}
