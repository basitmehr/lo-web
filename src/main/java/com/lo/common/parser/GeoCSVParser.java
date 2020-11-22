package com.lo.common.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class GeoCSVParser {
	
	public static void main(String arg[]) {
		
        try
        {
            try {
                FileInputStream fis = new FileInputStream(Paths.get( "C:\\Users\\basit\\Desktop\\Desktop\\lotsopening\\US\\simplemaps_uscities_basicv1.7\\uscities.csv" ).toFile());
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader br = new BufferedReader(isr);

                String line;
                
                FileWriter writer = new FileWriter("C:\\Users\\basit\\Desktop\\Desktop\\lotsopening\\US\\USCopy2.txt", true);

                while ( ( line = br.readLine() ) != null )
                {
                	String[] tokens = line.split(",");
                	
                	StringBuilder sb = new StringBuilder();
                	for(int i=0; i<tokens.length;i++) {
                		tokens[i] = tokens[i].replace("\"", "");
                		sb.append(tokens[i]).append("\t");
                	}
                    
//                    System.out.println(StringUtils.join(tokens, "\t"));
                    
                    writer.write(sb.toString());
                    writer.write("\r\n");   // write new line                    
                    
                }
                
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } catch (Exception e )
        {
            e.printStackTrace ();
        }		
		
	}
	

}
