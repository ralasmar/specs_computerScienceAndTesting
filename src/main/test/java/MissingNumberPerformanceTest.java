package main.test.java;
import static org.junit.Assert.*;

import main.java.MissingNumber;
import org.junit.Test;

public class MissingNumberPerformanceTest {
    private int[] missingMax = {1,2,3,4,5,6,7,8,9};
    private int[] missingNone = {1,2,3,4,5,6,7,8,9,10};
    private int[] missingSix = {1,2,3,4,5,7,8,9,10};
    private int[] missingMin = {2,3,4,5,6,7,8,9,10};
    private int max = 10;
    private MissingNumber missNum = new MissingNumber();

    @Test(timeout = 100)
    public void testMissingNumber_Performance(){
        for (int i=0; i< 1000000; i+=1){
            missNum.missingNumber(missingMax, max);
            missNum.missingNumber(missingNone, max);
            missNum.missingNumber(missingSix, max);
            missNum.missingNumber(missingMin, max);
        }
    }
    @Test(timeout = 100)
    public void testMissingNumberSort_Performance(){
        for (int i=0; i< 1000000; i+=1){
            missNum.missingNumberSort(missingMax, max);
            missNum.missingNumberSort(missingNone, max);
            missNum.missingNumberSort(missingSix, max);
            missNum.missingNumberSort(missingMin, max);
        }
    }
    @Test(timeout = 100)
    public void testMissingNumberSum_Performance(){
        for (int i=0; i< 1000000; i+=1){
            missNum.missingNumberSum(missingMax, max);
            missNum.missingNumberSum(missingNone, max);
            missNum.missingNumberSum(missingSix, max);
            missNum.missingNumberSum(missingMin, max);
        }
    }

}