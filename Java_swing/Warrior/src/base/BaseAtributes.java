package base;

public abstract class BaseAtributes {

	protected double lifePoints;
	protected double stamina;
	protected double attackSpeed;
	protected double hitDamage;

	public BaseAtributes(double[] args) {
		this.lifePoints = args[0];
		this.stamina = args[1];
		this.attackSpeed = args[2];
		this.hitDamage = args[3];
	}
	
	public BaseAtributes(double lifePoints, double stamina, double attackSpeed, double hitDamage) {
		this.lifePoints = lifePoints;
		this.stamina = stamina;
		this.attackSpeed = attackSpeed;
		this.hitDamage = hitDamage;
	}

    public boolean isAlive() {
        return lifePoints > 0;
    }
    
    public double attack(int stamina) {
    	if(stamina < 0) {
    		return -1;
    	}
    	double a = stamina/4;
    	stamina -= a;
    	return hitDamage;
    }
    
    public double getLifePoints() {
        return lifePoints;
    }
    
    public void setLifePoints(double lifePoints) {
        this.lifePoints = lifePoints;
    }
    
    public void takeDamage(double damage) {
        this.lifePoints = Math.max(0, lifePoints - damage);
    }
    
    public void rest(double stamina) {
    	this.stamina = (stamina/2);
    }
}
