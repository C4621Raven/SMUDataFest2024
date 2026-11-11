import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class DataFestCheckpointsEOC
{

	private static HashMap<String, Student> stuMap = new HashMap<String,Student>();
	
	public static void main(String[] args) throws IOException
	{
		FileReader fr = null;
		BufferedReader br = null;
		
		Path eocPath = Paths.get("checkpoints_eoc.csv");
		File eocFile = eocPath.toFile();	
		fr = new FileReader(eocFile);
		br = new BufferedReader(fr);
		
		br.readLine();
		String line = br.readLine();
		
		while(line != null)
		{
			String[] lineSplit = line.split(",");
			
			if(!stuMap.containsKey(lineSplit[0]))
			{
				stuMap.put(lineSplit[0], new Student());
			}
			
			//sets the book
			stuMap.get(lineSplit[0]).setBook(lineSplit[3]);
			
			//sets the ECOC
			try
			{
				stuMap.get(lineSplit[0]).getMap().get(Integer.parseInt(lineSplit[2])).setEOC(Double.parseDouble(lineSplit[4]));
			}
			catch(Exception e)
			{
			}
			
			//sets the attempts
			stuMap.get(lineSplit[0]).getMap().get(Integer.parseInt(lineSplit[2])).setAtt(Integer.parseInt(lineSplit[7]));
			
			line = br.readLine();
			
		}
		
		Path pagePath = Paths.get("page_views.csv");
		File pageFile = pagePath.toFile();	
		fr = new FileReader(pageFile);
		br = new BufferedReader(fr);
		
		br.readLine();
		line = br.readLine();
		
		while(line != null)
		{
			String[] lineSplit = line.split(",(?!\\s)");
			
			try
			{
				stuMap.get(lineSplit[8]).getMap().get(Integer.parseInt(lineSplit[4])).time += 
					Integer.parseInt(lineSplit[13]);
			}
			catch(Exception e)
			{
			}
			
			line = br.readLine();
		}
		
		Path pulsePath = Paths.get("checkpoints_pulse.csv");
		File pulseFile = pulsePath.toFile();	
		fr = new FileReader(pulseFile);
		br = new BufferedReader(fr);
		
		br.readLine();
		line = br.readLine();
		
		while(line != null)
		{
			String[] lineSplit = line.split(",");
			
			
			if(!lineSplit[7].equals("NA"))
			{
				if(lineSplit[6].equals("Cost"))
				{
					stuMap.get(lineSplit[4]).getMap().get(Integer.parseInt(lineSplit[5])).cost = Integer.parseInt(lineSplit[7]);
				}
			
				if(lineSplit[6].equals("Expectancy"))
				{
					stuMap.get(lineSplit[4]).getMap().get(Integer.parseInt(lineSplit[5])).expect = Integer.parseInt(lineSplit[7]);
				}
			
				if(lineSplit[6].equals("Intrinsic Value"))
				{
					stuMap.get(lineSplit[4]).getMap().get(Integer.parseInt(lineSplit[5])).intrist = Integer.parseInt(lineSplit[7]);
				}
			
				if(lineSplit[6].equals("Utility Value"))
				{
					stuMap.get(lineSplit[4]).getMap().get(Integer.parseInt(lineSplit[5])).utility = Integer.parseInt(lineSplit[7]);
				}
			}
			
			line = br.readLine();
			
			
		}
		System.out.println(getStuString("faa80c7f-4baa-4a70-abb0-867ad4d78138"));
		/*
		for(String id : stuMap.keySet())
		{
			try
			{
			if(stuMap.get(id).getMap().get(10).attempts>8000)
				System.out.println(id);
			}
			catch(Exception e)
			{
				
			}
		}*/
		
		
		
		
		//System.out.println(stuMap.size());
		/*
		Path outPath = Paths.get("Attempts-EOC.csv");
		File outFile = outPath.toFile();	
		FileWriter fw = new FileWriter(outFile);
		/*
		String chap = "";
		String depen = "";	
		
		String out = chap+","+depen;
		out+="\n";
		
		Path topStuPath = Paths.get(".csv");
		File topStuFile = topStuPath.toFile();	
		fr = new FileReader(topStuFile);
		br = new BufferedReader(fr);
		
		br.readLine();
		
		for(int i = 100;i>0;i--)
		{
			line = br.readLine();
			
			
		}
		
		
		*/
		
		/*
		String out = "Attempts,EOC,";
		for(int i = 1; i<= 16; i++)
		{
			out+="Chapter " + i +",";
		}
		out+="\n";
		
		for(String id : stuMap.keySet())
		{
			for(int i = 1; i <= 16; i++)
			{	
				out+=stuMap.get(id).getMap().get(i).attempts+",";
				out+=stuMap.get(id).getMap().get(i).EOC+",";
				out+="Chapter " + i + "\n";
			}
		}
		fw.write(out);
		fw.close();
		
		System.out.println("Finished");
		
		/*
		String Col1 = "Intrinsic Value";
		String Col2 = "Time";
		
		String out = "";
		
		out+="Chapter 1,,Chapter 2,,Chapter 3,,Chapter 4,,Chapter 5,,Chapter 6,,Chapter 7,,Chapter 8,,";
		out+="Chapter 9,,Chapter 10,,Chapter 11,,Chapter 12,,Chapter 13,,Chapter 14,,Chapter 15,,Chapter 16";
		
		out+="\n" + Col1 + "," + Col2 + "," + Col1 + "," + Col2 + "," + Col1 + "," + Col2 + "," + Col1 + "," + Col2 + "," + Col1 + "," + Col2 + "," + Col1 + "," + Col2 + "," + Col1 + "," + Col2 + "," + Col1 + "," + Col2 + "," + Col1 + "," + Col2 + "," + Col1 + "," + Col2 + "," + Col1 + "," + Col2 + "," + Col1 + "," + Col2 + "," + Col1 + "," + Col2 + "," + Col1 + "," + Col2 + "," + Col1 + "," + Col2 + "," + Col1 + "," + Col2 + ",";
		
		out+="\n";
		
		for(String id : stuMap.keySet())
		{
			for(int i = 1; i <= 16; i++)
			{	
				out+=stuMap.get(id).getMap().get(i).intrist+",";
				out+=stuMap.get(id).getMap().get(i).time+",";
			}
			out+="\n";
		}
		
		
		
		
		
		fw.write(out);
		fw.close();
		
		System.out.println("Finished " + stuMap.size());
		
		System.out.println(stuMap.keySet());
		
		*/
	}
	
	private static String getStuString(String id)
	{
		String out = "";
		
		out+="Student: " + id +"\n";
		out+="Book: " + stuMap.get(id).book +"\n\n";
		
		for(int i = 1; i <= 16; i++)
		{
			int chap = i;
			out+= "Chapter " + chap + ":" + "\n";
			out+= "Time: " + stuMap.get(id).getMap().get(chap).time + "\n";
			out+= "Attempts: " + stuMap.get(id).getMap().get(chap).attempts + "\n";
			out+= "EOC: " + stuMap.get(id).getMap().get(chap).EOC + "\n";
			out+= "Cost: " + stuMap.get(id).getMap().get(chap).cost + "\n";
			out+= "Expectancy: " + stuMap.get(id).getMap().get(chap).expect + "\n";
			out+= "Intrinsic Value: " + stuMap.get(id).getMap().get(chap).intrist + "\n";
			out+= "Utility Value: " + stuMap.get(id).getMap().get(chap).utility + "\n\n";
		}
		return out;
	}
	
	
	//inner class student
	static class Student
	{	
		String book;
		
		private HashMap<Integer, chapter> chapters  = new HashMap<Integer, chapter>();
		
		public Student()
		{
			//HashMap<Integer, chapter> chapters = new HashMap<Integer, chapter>();
			chapters.put(1, new chapter());
			chapters.put(2, new chapter());
			chapters.put(3, new chapter());
			chapters.put(4, new chapter());
			chapters.put(5, new chapter());
			chapters.put(6, new chapter());
			chapters.put(7, new chapter());
			chapters.put(8, new chapter());
			chapters.put(9, new chapter());
			chapters.put(10, new chapter());
			chapters.put(11, new chapter());
			chapters.put(12, new chapter());
			chapters.put(13, new chapter());
			chapters.put(14, new chapter());
			chapters.put(15, new chapter());
			chapters.put(16, new chapter());
		}
		
		public void setBook(String book)
		{
			this.book = book;
		}
		
		public HashMap<Integer, chapter> getMap()
		{
			return chapters;
		}
	}
	
	//inner class chapter
	static class chapter
	{
		Double EOC;
		Integer attempts;
		
		int time = 0;
		//int access;
		//int prop;
		
		Integer cost;
		Integer expect;
		Integer intrist;
		Integer utility;
		
		public void setEOC(double EOC)
		{
			this.EOC = EOC;
		}
		
		public void setAtt(int attempts)
		{
			this.attempts = attempts;
		}
	}
}