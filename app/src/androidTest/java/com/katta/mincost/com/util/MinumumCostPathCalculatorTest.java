package com.katta.mincost.com.util;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4.class)
public class MinumumCostPathCalculatorTest {

    MinimumCostPathCalculator minimumCostPathCalculator = new MinimumCostPathCalculator();

    @Test
    public void testIntializeGridWithValues() {
        minimumCostPathCalculator.createInputGrid(6, 6);
        int[][] costOfGrid = {{3, 4, 1, 2, 8, 6}, {6, 1, 8, 2, 7, 4}, {5, 9, 3, 9, 9, 5}, {8, 4, 1, 3, 2, 6}, {3, 7, 2, 8, 6, 4}, {3, 7, 2, 1, 2, 3}};
        minimumCostPathCalculator.intializeGridwithValues(InstrumentationRegistry.getContext(), costOfGrid);
        assertEquals(minimumCostPathCalculator.inputGrid, costOfGrid);
    }

    @Test
    public void testCalculateMinimumCostPath() {

        minimumCostPathCalculator.createInputGrid(6, 6);
        int[][] costOfGrid = {{3, 4, 1, 2, 8, 6}, {6, 1, 8, 2, 7, 4}, {5, 9, 3, 9, 9, 5}, {8, 4, 1, 3, 2, 6}, {3, 7, 2, 8, 6, 4}, {3, 7, 2, 1, 2, 3}};
        minimumCostPathCalculator.intializeGridwithValues(InstrumentationRegistry.getContext(), costOfGrid);
        String returnedString = minimumCostPathCalculator.calculateMinimumCostPath();

        String[] resultStrings = returnedString.split("&&");

        assertEquals("3--->4--->5--->6--->8--->11--->", resultStrings[0].trim());
        assertEquals("11", resultStrings[1].trim());

    }

}
