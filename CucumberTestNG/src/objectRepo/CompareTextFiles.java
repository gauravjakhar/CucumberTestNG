package objectRepo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class CompareTextFiles {

	static final String file1 = "C:\\jakhar\\FilesCompare\\1.txt";
	static final String file2 = "C:\\jakhar\\FilesCompare\\2.txt";
	static final String output = "C:\\jakhar\\FilesCompare\\test.html";

	static BufferedReader br1 = null;
	static BufferedReader br2 = null;
	
	public static void main(String[] args) throws IOException {
	    
	    String lineTextFile1 = null;
	    String lineTextFile2 = null;
	    
	    //html code, can be replaced with reporting.
	    OutputStream htmlfile= new FileOutputStream(new File(output));
		PrintStream printhtml = new PrintStream(htmlfile);	
		printhtml.println("<html><head><title>Compare Files</title></head><body><table border=1 "
				+ "cellpadding=2 cellspacing=0><tr><th>" + "Source" + "</th><th>" + "Dest" + "</th><th>Result</th>");
		//
		
		
	    try {
	    	
	        br1 = new BufferedReader(new FileReader(file1));
	        br2 = new BufferedReader(new FileReader(file2));
	        
	        while((lineTextFile1 = br1.readLine()) != null && (lineTextFile2 = br2.readLine()) != null){
	          	if(lineTextFile1.equals(lineTextFile2))
	        		printhtml.println("<tr><td>" + lineTextFile1 + "</td><td>" + lineTextFile2 + "</td><td>Match</td>" );
	        	else
	        		printhtml.println("<tr><td>" + lineTextFile1 + "</td><td>" + lineTextFile2 + "</td><td>No Match</td>" );
	        }
	        
        	if(lineTextFile1 == null ) {        		
        		while((lineTextFile2 = br2.readLine()) != null)
        		printhtml.println("<tr><td></td><td>" + lineTextFile2 + "</td><td>No Match</td>" );
        	}
        	else if(lineTextFile2 == null) {
        		printhtml.println("<tr><td>" + lineTextFile1 + "</td><td></td><td>No Match</td>" );
        		while((lineTextFile1 = br1.readLine()) != null)
        		printhtml.println("<tr><td>" + lineTextFile1 + "</td><td></td><td>No Match</td>" );
        	}
	        
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();	    
	    }
	    
	    printhtml.println("</table></body></html>");	    
	    printhtml.close();
	    htmlfile.close();
	    br1.close();
	    br2.close();
	}
}
