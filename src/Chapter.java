import java.util.ArrayList;

public class Chapter
{
	private int chapter;
	private ArrayList<Integer> attempts_Col;
	private ArrayList<Double> EOC_Col;
	
	private ArrayList<Integer> attempts_HS;
	private ArrayList<Double> EOC_HS;
	
	private ArrayList<Integer> attempts;
	private ArrayList<Double> EOC;
	
	public Chapter(int chap)
	{
		chapter = chap;
		attempts_Col = new ArrayList<Integer>();
		EOC_Col = new ArrayList<Double>();
		
		attempts_HS = new ArrayList<Integer>();
		EOC_HS = new ArrayList<Double>();
		
		attempts = new ArrayList<Integer>();
		EOC = new ArrayList<Double>();
	}
	
	public void addAttempt_Col(int val)
	{
		attempts_Col.add(val);
		attempts.add(val);
	}
	public void addAttempt_HS(int val)
	{
		attempts_HS.add(val);
		attempts.add(val);
	}
	
	public void addEOC_Col(double val)
	{
		EOC_Col.add(val);
		EOC.add(val);
	}
	public void addEOC_HS(double val)
	{
		EOC_HS.add(val);
		EOC.add(val);
	}
	
	public double averAtt_Col()
	{
	    double sum = 0;
	    for (int i=0; i< attempts_Col.size(); i++)
	    {
	          sum += attempts_Col.get(i);
	    }
	    return sum / attempts_Col.size();
	 }
	public double averAtt_HS()
	{
	    double sum = 0;
	    for (int i=0; i< attempts_HS.size(); i++)
	    {
	          sum += attempts_HS.get(i);
	    }
	    return sum / attempts_HS.size();
	 }
	public double averAtt()
	{
	    double sum = 0;
	    for (int i=0; i< attempts.size(); i++)
	    {
	          sum += attempts.get(i);
	    }
	    return sum / attempts.size();
	 }
	
	public double averEOC_Col()
	{
	    double sum = 0;
	    for (int i=0; i< EOC_Col.size(); i++)
	    {
	          sum += EOC_Col.get(i);
	    }
	    return sum / EOC_Col.size();
	 }
	public double averEOC_HS()
	{
	    double sum = 0;
	    for (int i=0; i< EOC_HS.size(); i++)
	    {
	          sum += EOC_HS.get(i);
	    }
	    return sum / EOC_HS.size();
	 }
	public double averEOC()
	{
	    double sum = 0;
	    for (int i=0; i< EOC.size(); i++)
	    {
	          sum += EOC.get(i);
	    }
	    return sum / EOC.size();
	 }
	
	public int getAttSize_Col()
	{
		return attempts_Col.size();
	}
	public int getAttSize_HS()
	{
		return attempts_HS.size();
	}
	public int getAttSize()
	{
		return attempts.size();
	}
}