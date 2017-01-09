package com.katta.venkatesh.com.katta;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
          init();
    }


     public void init(){

         Button startButton = (Button)findViewById(R.id.start_button);
          final Context context = this;

         startButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 MinimumCostPathCalculator minimumCostPathCalculator = new MinimumCostPathCalculator();

                 EditText rowSizeField = (EditText) findViewById(R.id.row_size);
                 int rowSize = Integer.valueOf(rowSizeField.getText().toString());

                 EditText colSizeField = (EditText) findViewById(R.id.column_size);
                 int colSize = Integer.valueOf(colSizeField.getText().toString());
                 int[][] costOfGrid = new int[rowSize][colSize];
                 // int[][] costOfGrid = {{3,4,1,2,8,6},{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,8,6,4},{3,7,2,1,2,3}};

                 EditText gridEntryField = (EditText)findViewById(R.id.grid_elements);
                 String[] stringArrayOfMatrixInput  =  gridEntryField.getText().toString().split(" ");


                 if(stringArrayOfMatrixInput.length<rowSize*colSize){

                     new AlertDialog.Builder(context).
                             setTitle("Error").
                             setMessage("Grid is not full yet please enter more elements").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                         }
                     });

                 }


                 Log.d("rowSize", String.valueOf(rowSize));
                 Log.d("colSize",String.valueOf(colSize));

                 for(int i=0;i<rowSize;i++) {
                     for(int j=0;j<colSize;j++) {

                           costOfGrid[i][j] = Integer.parseInt(stringArrayOfMatrixInput[i*colSize+j]);
                           Log.d("costOfGrid[" + i + "]" + "[" + j + "]", String.valueOf(costOfGrid[i][j]));

                     }

                 }

                 minimumCostPathCalculator.createInputGrid(rowSize,colSize);
                 minimumCostPathCalculator.intializeGridwithValues(context,costOfGrid);
                 String result = minimumCostPathCalculator.calculateMinimumCostPath();
                 String[] resultStrings = result.split("&&");

                 TextView resultViewOne = (TextView) findViewById(R.id.resultsView1);
                 TextView resultViewTwo =(TextView) findViewById(R.id.resultsView2);
                 resultViewOne.setText("Minimum Cost Path :" +resultStrings[0]);
                 resultViewTwo.setText("Minimum Cost  :" +resultStrings[1]);
             }
         });

      }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
