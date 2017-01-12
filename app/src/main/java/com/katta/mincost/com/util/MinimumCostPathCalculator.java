package com.katta.mincost.com.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by venkatesh on 1/8/17.
 */

public class MinimumCostPathCalculator {

    int[][] inputGrid;
    int[][] temp;
    int gridRows, gridColumns;

    public int[][] createInputGrid(int rows, int columns) {

        inputGrid = new int[rows][columns];
        gridRows = rows;
        gridColumns = columns;
        return inputGrid;
    }

    /**
     * Initialize the Grid with Values
     *
     * @param context     The context of the Activity the takes input from the user
     * @param costsOfGrid Input Grid elements entered by the user
     */

    public void intializeGridwithValues(Context context, int[][] costsOfGrid) {

    /*
       Check if the Grid Size given by the user matches the actual grid given
     */
        if ((costsOfGrid.length != inputGrid.length) || (inputGrid[0].length != costsOfGrid[0].length)) {

            new AlertDialog.Builder(context)
                    .setTitle("Error")
                    .setMessage("Grid Values entered does not fit in to the Given Grid size")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .show();
        } else {
            inputGrid = costsOfGrid;
        }

    }


    /**
     * This Method Calculates the MinimumCostPath and returns the String
     */

    public String calculateMinimumCostPath() {

        //Grid to Store Minimum Cost of reaching each cell in the grid
        temp = new int[gridRows][gridColumns];

        //Minumum cost of reaching first column in the Grid is given cost of first column cell only
        for (int i = 0; i < gridRows; i++) {
            temp[i][0] = inputGrid[i][0];
        }


        for (int j = 1; j < gridColumns; j++) {

            for (int i = 0; i < gridRows; i++) {

                if (i == 0) {

                    int min = Math.min(temp[gridRows - 1][j - 1], temp[i + 1][j - 1]);

                    temp[i][j] = inputGrid[i][j] + Math.min(min, temp[i][j - 1]);

                } else if (i == gridRows - 1) {

                    int min = Math.min(temp[i - 1][j - 1], temp[0][j - 1]);

                    temp[i][j] = inputGrid[i][j] + Math.min(min, temp[i][j - 1]);

                } else {

                    int min = Math.min(temp[i - 1][j - 1], temp[i + 1][j - 1]);

                    temp[i][j] = inputGrid[i][j] + Math.min(min, temp[i][j - 1]);
                }
            }
        }

        return constructMinimalCostPathandMinimalCost();

    }

    /**
     * Constructs the Minimum Cost Path and Calculates and finds the Minimum
     * Cost required to traverse the Grid.
     *
     * @return Results MinimalCostPath and Minimum Cost of the Grid
     */

    public String constructMinimalCostPathandMinimalCost() {

        //pathArray stores the rows with minimum cost values for each column to construct the path
        int[] pathArray = new int[gridColumns];
        StringBuilder sb = new StringBuilder();
        int minimumCostRow = 0;
        for (int j = 0; j < gridColumns; j++) {
            int mincost = Integer.MAX_VALUE;

            for (int i = 0; i < gridRows; i++) {
                if (mincost > temp[i][j]) {
                    mincost = temp[i][j];
                    minimumCostRow = i;
                }
            }

            pathArray[j] = minimumCostRow;
            sb.append(String.valueOf(temp[pathArray[j]][j]) + "--->");

            //  Log.d("MinimalCostPath", String.valueOf(temp[pathArray[j]][j])+"--->");

        }

        //  Log.d("MinimumCost is ",String.valueOf(temp[pathArray[gridColumns-1]][gridColumns-1]));
        sb.append("  && " + String.valueOf(temp[pathArray[gridColumns - 1]][gridColumns - 1]));

        return sb.toString();
    }


}



