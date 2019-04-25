import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Testing {

	public static void main(String[] args) {
		
		// large test 25 columns
		test("1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10 10 11 11 12 12 13 13 14 14 15 15 16 16 17 17 18 18 19 19 20 20 21 21 22 22 23 23 24 24 25 25",false);
		// 10 column test
		test("1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10 10",false);
		// 5 column test
		test("1 1 2 2 3 3 4 4 5 5",false);
		// packet example
		test("4 7 1 1 5 9 2 3",true);
		// impossible test
		test("1 9 2 1 3 2 4 3",false);
		// too few columns test 
		test("1 2 2 1",false);
		
	}
	//pass in boolean to see combos
	public static void test(String in, boolean results) {
		
		long start;
		long end;
		String input = in;
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
		start = System.nanoTime();
		for(Column current : columns) {
			findLines(lines, new ColumnLine(current), columns);
		}
		
		System.out.println(lines.size());
		if(results) {
			for(ArrayList<Column> alp : lines) {
				for(Column pil : alp) {
					System.out.print(pil.getRadius()+" ");
				}
				System.out.println();
			}
		}
		end = System.nanoTime();
		System.out.println("Running time: " + (end - start));
	}
	public static void findLines(ArrayList<ArrayList<Column>> lines, ColumnLine cl, ArrayList<Column> cList) {

		ColumnLine line = cl;
		ArrayList<Column> current = new ArrayList<Column>();
		current.addAll(cList);
		
		if(line.getLine().size() < 4) {

			Column recent = line.getLine().get(line.getLine().size()-1);
			int index = current.indexOf(recent);
			
			for(int i = 0; i <= index; i++)
				current.remove(0);
			
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
