
public class Column {
	private int radius;
	private int height;
	
	public Column() {
		this.radius = -1;
		this.height = -1;
	}
	public Column(int radius, int height) {
		this.radius = radius;
		this.height = height;
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
		if(this.height < other.height) return 1;
		else if(this.height > other.height) return -1;
		else return 0;
	}
	
	public String toString() {
		return "(" + this.height + "," + this.radius + ")";
	}
}
