package sd03;

public class items {
	int index;
	String itemname; // should always be non-negative
	int price = 0; // should always be non-negative
	int itemnum= 0;
	
	public items(int index,String name,int price) {
		this.index=index;
		this.itemname=name;
		this.price=price;
	}
	public String toString() {
		return String.format("%5d | %s | %5d | %5d", index, itemname, price, itemnum);
	}
}
