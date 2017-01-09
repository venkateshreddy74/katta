package com.katta.venkatesh.com.katta;



import android.support.test.InstrumentationRegistry;
import android.test.AndroidTestCase;

import org.junit.Test;

import static org.junit.Assert.*;


public class MinimumCostPathCalculatorTest {

   MinimumCostPathCalculator minimumCostPathCalculator= new MinimumCostPathCalculator();




    @Test
    public void testCreateInputGrid(){

        minimumCostPathCalculator.createInputGrid(6,6);
        assertEquals(minimumCostPathCalculator.gridColumns,6);
        assertEquals(minimumCostPathCalculator.gridRows,6);
    }

    @Test

    public void testIntializeGridWithValues(){
        int[][] costOfGrid = {{3,4,1,2,8,6},{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,8,6,4},{3,7,2,1,2,3}};
        minimumCostPathCalculator.intializeGridwithValues(InstrumentationRegistry.getContext(),costOfGrid);
       assertEquals(minimumCostPathCalculator.inputGrid,costOfGrid);
    }



}


