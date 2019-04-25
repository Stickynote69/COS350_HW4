import java.util.ArrayList;

public class ColumnLine {
	
	private ArrayList<Column> line;
	private boolean crossed = false;
	private boolean valid = true;
	
	public ColumnLine()
	{
		line = new ArrayList<Column>();
	}
	
	public ColumnLine(Column c)
	{
		line = new ArrayList<Column>();
		line.add(c);
	}
	
	public boolean valid()
	{
		return valid;
	}
	
	public ArrayList<Column> getPath()
	{
		return line; 
	}
	
	public void setPath(ArrayList<Column> c)
	{
		line = c; 
	}
	
	public void add(Column c)
	{
		int pre_radi = line.get(line.size()-1).getRadius();
		if(!crossed)
		{
			if(c.getRadius()< pre_radi) line.add(c);
			else
			{
				crossed = true;
				line.add(c);
			}
		}
		else
		{
			if(c.getRadius() > pre_radi) line.add(c);
			else
			{
				valid = false;
				line.add(c);
			}
		}
	}
	
	public void copy(ColumnLine other)
	{
		line.addAll(other.getPath());
		valid = other.valid;
		crossed = other.getCrossed();
	}
	
	public String toString()
	{
		return ""+line.toString()+"("+crossed+","+valid+")";
	}
	
	private boolean getCrossed()
	{
		return crossed;
	}
}
