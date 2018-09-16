package calci;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class UBSStringCal {

    public static String add(String input) {
        InnerStringCalculator calculator = new InnerStringCalculator(input);
        return calculator.add();
    }

    static class InnerStringCalculator {
        private final String input;

        private String delimiter = "\\D";

        private InnerStringCalculator(String input) {
            this.input = input;
        }

        public  String add() {

  		  if ((input.equals(null)) || (input.equals("")))
  		   return "0";

  		  if(!handleNewLines(input))
  			  return "0";
  		  
  		  if(handleNegatives(input))
  			  return "negatives not allowed" + " : " +input.replaceAll("-", "");
  		  
  		  String stringArr[] = input.split(delimiter);
  		  int total = 0;
  		  for (String stringVal : stringArr) {
  			  if(isNullOrEmpty(stringVal)) {
  				  if(isInValidRange(Integer.parseInt(stringVal)))
  		   total += Integer.parseInt(stringVal);
  			  }
  			  
  		  }
  		  return String.valueOf(total);
  		 }
  		
  		 public  boolean handleNewLines(String str) {
  		        if(str.startsWith("\n") || str.endsWith("\n"))
  		            return false;
  		        return true;
  		    }
  		 
  		 public  boolean handleNegatives(String str) {
  		        if(StringUtils.countMatches(str, "-") > 0)
  		            return true;
  		       return false;
  		    }
  		 
  		 
  		 public  boolean isNullOrEmpty(String str) {
  		        if(str.equals(""))
  		            return false;
  		        return true;
  		    }
  		 
  		  private  boolean isInValidRange(Integer valueAsInteger) {
  	            return valueAsInteger < 1000;
  	        }
    }
}