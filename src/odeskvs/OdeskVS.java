/**
* Simple program asked by Raluca Ulici, oDesk
* 
* Write a function that takes an array of integers and returns that array rotated by N positions.
* For example, if N=2, given the input array [1, 2, 3, 4, 5, 6] the function 
* should return [5, 6, 1, 2, 3, 4]
*
* @author  Sándor Varga
* @version 0.1
* @since   2014-12-17 
*/
package odeskvs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OdeskVS {

    /*This code was developed in Netbeans 8, using Java 8. It is recommended to be run in the workspace, 
    with right-click of the mouse on the "Source Packages/OdeskVS.java" and click on "Run".
    The Netbeans console shows the results.
    
    It can be run from command line, too, with the command java OdeskVS.java
    
    The tests are implemented in the "Test Packages/OdeskVSTest.java" file. Full unit tests are provided,
    description and running instructions in that file.
    */
    
    public static void main(String[] args) {
        //args arguments are not used, because it would be inappropriate to
        //send an array of integers combined in an array of Strings.
        //Hovewer, it can be forced as needed
        
        //The example given by Raluca for test
        Integer[] array = {1, 2, 3, 4, 5, 6};
        int steps = 2;
        System.out.println("Original array:"+Arrays.toString(array));
        System.out.println("Rotate 1 result:"+Arrays.toString(rotateArray1(array, steps)));
        System.out.println("Rotate 2 result:"+Arrays.toString(rotateArray2(array, steps)));
        System.out.println("Rotate 3 result:"+Arrays.toString(rotateArray3(array, steps)));
    }
    /*Three different versions offered as solutions. Will be described at the beniining of the methods*/
    
    public static Integer[] rotateArray3(Integer[] origArray, int steps) {
        /*This is an elegant method, using the Collections framework. We have to create a copy of the
        original array ba System.arraycopy to preserve the original one for further operations.
        It is elegant, fast, but not memory-saver.
        */
        if(origArray == null) {
            return null;
        }                
        int len = origArray.length;
        Integer[] copyArray = new Integer[len];
        System.arraycopy(origArray, 0, copyArray, 0, len);
        List origList = Arrays.asList(copyArray);
        Collections.rotate(origList, steps);
        /*A copy of the array is made to be returned. Hovewer, the original could used too, but
        I want to preserve the original for future operations (it is transmitted by reference
        to the method
        */
        Integer[] resultArray = (Integer[])origList.toArray(new Integer[len]);
        return resultArray;
    }
    
    public static Integer[] rotateArray2(Integer[] origArray, int steps) {
        /*This is an elegant and low memory consumption version. It splits the original 
        array in two parts based on the number of rotation steps and combines the result from
        these.
        */
        if(origArray == null) {
            return null;
        }        
        int len = origArray.length;
        Integer[] resultArray = new Integer[len];
        /*When the steps exceeds the arrays size*/
        steps = steps % len;   
        /*Treat the situation when we have negative steps*/
        if(steps<0) {
            steps = len+steps;
        }        
        /*A copy of the array is made to be returned. Hovewer, the original could used too, but
        I want to preserve the original for future operations (it is transmitted by reference
        to the method
        */        
        System.arraycopy(origArray, 0, resultArray, steps, len-steps);
        System.arraycopy(origArray, len-steps, resultArray, 0, steps);
        return resultArray;
    }
    
    public static Integer[] rotateArray1(Integer[] origArray, int steps) {
        /*This is the basic solution, with iteration over the original array and combining the
        elements in a second array simulating a circular shifment, that means a rotation.
        */
        if(origArray == null) {
            return null;
        }
        int len = origArray.length;
        Integer[] resultArray = new Integer[len];
        int j = 0;
        /*When the steps exceeds the arrays size*/
        steps = steps % len;        
        /*Treat the situation when we have negative steps*/
        if(steps<0) {
            steps = len+steps;
        }
        /*Here we populate the result array by splitting the behaviour*/
        for(int i : origArray) {
            if((j+steps)<len) {
                resultArray[j+steps] = i;
            } else {
                resultArray[j+steps-len] = i;
            }
            j++;
        }
        /*A copy of the array is made to be returned. Hovewer, the original could used too, but
        I want to preserve the original for future operations (it is transmitted by reference
        to the method
        */        
        return resultArray;
    }
}
