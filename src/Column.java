
public class Column {
	private int height;
	private int radius;
	
	public Column() {
		this.height = -1;
		this.radius = -1;
	}
	public Column(int height, int radius) {
		this.height = height;
		this.radius = radius;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public int compareTo(Column other) {
		if(this.height > other.height) return 1;
		else if(this.height < other.height) return -1;
		else return 0;
	}
	
	public String toString() {
		return "(" + this.height + "," + this.radius + ")";
	}
}
