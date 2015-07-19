import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class Wilson {
	 public static double getPollen(){
		 String[] string = new String[2];;
	        try {
	            
	            URL oracle = new URL("http://www.wunderground.com/DisplayPollen.asp?Zipcode=03755");

	            BufferedReader in = null;

	            in = new BufferedReader(
	                    new InputStreamReader(oracle.openStream()));


	            String inputLine;
	            int i = 0;

	            while ((inputLine = in.readLine()) != null) {
	                if (i == 463) {

	                    string = inputLine.trim().split("<p>|</p>");

	                    //System.out.println((String) string[1]);

	                    //System.out.println(test);
	                    //System.out.println(inputLine);
	                    i++;
	                } else
	                    i++;

	            }
	            in.close();

	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
	        //System.out.println(string[1]);
	        return Double.parseDouble((string[1]));
	    }
	 	
	 public static double getTemperature() throws Exception{
		
	            
	            URL temp = new URL("http://www.wunderground.com/");

	            BufferedReader in = null;

	            in = new BufferedReader(
	                    new InputStreamReader(temp.openStream()));

	            String[] temperature = null;
	            String inputLine;
	            int i = 0;
	            
	            while ((inputLine = in.readLine()) != null) {
	               
	               if(inputLine.contains("wx-value") && i==0){
	            	   //System.out.println(inputLine);
	            	   String temp2=inputLine;
	            	   temperature=temp2.split(">|<");
	            	  /* for(int k=0;k<temperature.length;k++){
	            		   //System.out.println(temperature[k].toString());
	            	   }*/
	            	   i++;
	               }
	               
	            }
	            in.close();

	            
	            return Double.parseDouble(temperature[2]);
	        
	    } 	
	 
	 public static int getHumidity() throws Exception{
			
         
         URL humid = new URL("http://www.wunderground.com/cgi-bin/findweather/getForecast?query=43.722599,-72.134201&sp=KNHCANAA4&MR=1");

         BufferedReader in = null;

         in = new BufferedReader(
                 new InputStreamReader(humid.openStream()));

         String[] humidity = null;
         String inputLine;
         int h = 0;
         
         while ((inputLine = in.readLine()) != null) {
            
            if(inputLine.contains("wx-value") && h==17){
         	   //System.out.println(inputLine);
         	   String temp3=inputLine;
         	   //System.out.println(temp3);
         	   humidity=temp3.trim().split(">|<");
         	   /*for(int r=0;r<humidity.length;r++){
         		   System.out.println(humidity[r].toString());
         	   }*/
         	   h++;
         	 }
            else if(inputLine.contains("wx-value")){
            	h++;
            }
            
         	   
	        
         	  
            }
         in.close();
         
         return Integer.parseInt(humidity[2]);
         }
         

         
         //return temperature[2];
     
	 
/*	 public static void main(String[] args){
		 System.out.println(getPollen());
		 try {
			System.out.println(getTemperature());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			System.out.println(getHumidity());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }*/
}

