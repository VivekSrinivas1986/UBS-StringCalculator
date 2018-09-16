package calc;

import org.junit.Assert;
import org.junit.Test;

import calci.UBSStringCal;


public class UBSStringCalTest {
    @Test
    public void calculateEmptyResult() {
        Assert.assertEquals("0", UBSStringCal.add(""));
    }

    @Test
    public void calculateSingleNumber() {
        Assert.assertEquals("1", UBSStringCal.add("1"));
    }

    @Test
    public void calculateBasic() {
        Assert.assertEquals("2", UBSStringCal.add("2"));
    }

    @Test
    public void calculateSimplePositive() {
        Assert.assertEquals("3", UBSStringCal.add("2,1"));
    }

    @Test
    public void calculateNewlinesDelim() {
        Assert.assertEquals("3", UBSStringCal.add("2\n1"));
    }

    @Test
    public void calculateWithSquareCustomDelimiter() {
        Assert.assertEquals("3", UBSStringCal.add("//[x]\n2x1"));
    }

    @Test
    public void calculateWithCustomDelimiter() {
        Assert.assertEquals("3", UBSStringCal.add("//[xx]\n2xx1"));
    }

    @Test
    public void calculateMultipleDelimators() {
        Assert.assertEquals("6", UBSStringCal.add("//*|%\\n1*2%3"));
    }
    
    
  
    @Test
    public void calculateSingleNegativeValue() {
            UBSStringCal.add("-1");
    }

    @Test
    public void calculateTwoNegativeValue() {
            UBSStringCal.add("-1,-2");
    }

    @Test
    public void calculateCombination() {
        Assert.assertEquals("6", UBSStringCal.add("2,1001\n2delim2"));
    }
}
