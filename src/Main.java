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

		read.close();
		for(Column x : columns) {
			System.out.print(x);
		}
		
	}

	
}
