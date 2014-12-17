/**
* Simple program asked by Raluca Ulici, oDesk
* 
* Write a function that takes an array of integers and returns that array rotated by N positions.
* For example, if N=2, given the input array [1, 2, 3, 4, 5, 6] the function 
* should return [5, 6, 1, 2, 3, 4]
* 
* JUnit unit test for the program
*
* @author  Sándor Varga
* @version 0.1
* @since   2014-12-17 
*/
package odeskvs;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/* This is the test suite for the OdeskVS program.
Run this in Netbeans by right mouse click on this file and click on "Run". 
If you want to run it from command line, than execute command java OdeskVSTest.java 
having assured that OdeskVS class is accessible on the classpath.

The provided tests are Junit4 tests and use Equivalence partitioning and 
Boundary value analysis.
These are described as the values are prepared.

 */
public class OdeskVSTest {
    
    private Integer[] origArray;
    private int steps1;
    private Integer[] expResult1;
    private int steps2;
    private Integer[]  expResult2;
    private int steps3;
    private Integer[] expResult3;
    private int steps4;
    private Integer[] expResult4;
    private int steps5;
    private Integer[] expResult5;
    private int steps6;
    private Integer[] expResult6;
    private int steps7;
    private Integer[] expResult7;
    private int steps8;
    private Integer[] expResult8;    
    
    public OdeskVSTest() {    }
    
    @Before
    public void setUp() {
        origArray = new Integer[] {1, 2, 3, 4, 5, 6};
        int len = origArray.length;
        /*In every cases when an integer value can take the 0 value,
        software must be tested with 0
        */
        steps1 = 0;
        expResult1 = new Integer[] {1, 2, 3, 4, 5, 6};
        /*We have to test with a value between 0 and the border limit*/
        steps2 = 4;
        expResult2 =  new Integer[] {3, 4, 5, 6, 1, 2};
        /*Upper border limit is the length of the original array*/
        steps3 = len;
        expResult3 =  new Integer[] {1, 2, 3, 4, 5, 6};
        /*We extend to the partitioning outside the border as the task formulation
        did not contain limitation on this*/
        steps4 = len+1;
        expResult4 =  new Integer[] {6, 1, 2, 3, 4, 5};
        /*Values are not limited to integer values, so I have to test with lower value than 0*/
        steps5 = -2;
        expResult5 =  new Integer[] {3, 4, 5, 6, 1, 2};
        /*Another intermediate value*/
        steps6 = -4;
        expResult6 =  new Integer[] {5, 6, 1, 2, 3, 4};
        /*Negative border test*/
        steps7 = -(len);
        expResult7 =  new Integer[] {1, 2, 3, 4, 5, 6};                
        /*Extension outside of the negative border, as task formulation does not limit for that.*/
        steps8 = -(len+1);
        expResult8 =  new Integer[] {2, 3, 4, 5, 6, 1};                        
    }
    
    /**
     * Test of main method, of class OdeskVS.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        OdeskVS.main(args);
    }

    
    public void testRotateArray(Integer[] original, Integer[] expected, int step) {
        System.out.println("rotateArray1, "+step);        
        Integer[] result = OdeskVS.rotateArray1(original, step);
        assertArrayEquals(expected, result);
        System.out.println("rotateArray2, "+step);        
        result = OdeskVS.rotateArray2(original, step);
        assertArrayEquals(expected, result);        
        System.out.println("rotateArray3, "+step);        
        result = OdeskVS.rotateArray3(original, step);        
        assertArrayEquals(expected, result);                
    }
    /**
     * Test of rotateArray1 method, of class OdeskVS.
     */
    @Test
    public void testSuiteRotateArray() {
        /*In every cases when an integer value can take the 0 value,
        software must be tested with 0
        */
        testRotateArray(origArray, expResult1, steps1);
        /*We have to test with a value between 0 and the border limit*/
        testRotateArray(origArray, expResult2, steps2);
        /*Upper border limit is the length of the original array*/
        testRotateArray(origArray, expResult3, steps3);
        /*We extend to the partitioning outside the border as the task formulation
        did not contain limitation on this*/
        testRotateArray(origArray, expResult4, steps4);
        /*Values are not limited to integer values, so I have to test with lower value than 0*/        
        testRotateArray(origArray, expResult5, steps5);
        /*Another intermediate value*/
        testRotateArray(origArray, expResult6, steps6);
        /*Negative border test*/
        testRotateArray(origArray, expResult7, steps7);
        /*Extension outside of the negative border, as task formulation does not limit for that.*/        
        testRotateArray(origArray, expResult8, steps8);      
    }
}