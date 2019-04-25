import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = " ";
		input = scan.nextLine();	
		scan.close();
		ArrayList<Column> columns = new ArrayList<Column>();
		Scanner read = new Scanner(input);
		while(read.hasNextInt()) {
			Column temp;
			int h,r;
			h = read.nextInt();
			r = read.nextInt();
			temp = new Column(h,r);
			columns.add(temp);
		}
		sort(columns);
		
		read.close();
		for(Column x : columns) {
			System.out.print(x);
		}
		
	}
	public static void sort(ArrayList<Column> cols) {
		for(int x = 0; x < cols.size() - 1; x++) {
			int min = Integer.MAX_VALUE;
			int index = x + 1;
			for(int y = x; y < cols.size() - 1; y++) {
				if(cols.get(y).getHeight() < min) {
					index = y;
					min = cols.get(y).getHeight();
				}
			}
			Column temp = cols.get(x);
			cols.set(x, cols.get(index));
			cols.set(index,temp);
		}
	}
	

}
