package com.katta.mincost.com.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MinimumCostPathCalculatorTest {

    MinimumCostPathCalculator minimumCostPathCalculator = new MinimumCostPathCalculator();

    @Test
    public void testCreateInputGrid() {
        minimumCostPathCalculator.createInputGrid(6, 6);
        assertEquals(minimumCostPathCalculator.gridColumns, 6);
        assertEquals(minimumCostPathCalculator.gridRows, 6);
    }

}


