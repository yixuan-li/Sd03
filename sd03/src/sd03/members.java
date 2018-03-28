package sd03;

public class members {
	int index;
	String name;
	int move;
	int fight;
	int shoot;
	int armour;
	int morale;
	int health;
	int cost;
	String notes;
	boolean insquad;
	
	public members(int index,String name,int move,int fight,int shoot,int armour,int morale,int health,int cost,String notes,boolean insquad) {
		this.index=index;
		this.name=name;
		this.move=move;
		this.fight=fight;
		this.shoot=shoot;
		this.armour=armour;
		this.morale=morale;
		this.health=health;
		this.cost=cost;
		this.notes=notes;
		this.insquad=insquad;
	}
	
	public String toString() {
		return String.format("%5d | %s | %5d | %5d | %5d | %5d | %5d | %5d | %5d | %s | %s", index, name, move, fight,shoot,armour,morale,health,cost,notes,insquad);
	}
}
