import java.util.ArrayList;
import java.util.Collections;
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

		ArrayList<ArrayList<Column>> lines = new ArrayList<ArrayList<Column>>();
		
		Collections.sort(columns, new CompareColumn());
		
		for(Column current : columns) {
			findLines(lines, new ColumnLine(current), columns);
		}
		
		System.out.println(lines.size());
		for(ArrayList<Column> alp : lines) {
			for(Column pil : alp) {
				System.out.print(pil.getRadius()+" ");
			}
		}
		
	}
	
	public static void findLines(ArrayList<ArrayList<Column>> lines, ColumnLine cl, ArrayList<Column> cList) {

		ColumnLine line = new ColumnLine();
		line.copy(cl);
		ArrayList<Column> current = new ArrayList<Column>();
		current.addAll(cList);
		

		if(line.getLine().size() < 4) {

			Column recent = line.getLine().get(line.getLine().size()-1);
			int index = current.indexOf(recent);
			
			for(int i = 0; i <= index; i++) {
				current.remove(0);
			}
			
			for(Column cur : current) {
				ColumnLine temp = new ColumnLine();
				temp.copy(line);
				temp.add(cur);
				if(temp.valid()) {
					findLines(lines,temp,current);
				}
			}
		}
		else if(line.getLine().size()==4 && line.valid()) lines.add(line.getLine());
	}

	
}
