import java.util.Comparator;

public class CompareColumn implements Comparator<Column> {

	@Override
	public int compare(Column o1, Column o2) {
		return o1.getHeight() - o2.getHeight();
	}
	

}
