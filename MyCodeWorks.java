package test.codeworks;

/**
 * Created by VinothKumar on 1/27/2015.
 */
import java.lang.reflect.Array;
import java.util.Arrays;

public class MyCodeWorks {

    public static int count = 0;

    public static void main(String[] args) {


        //Please feel free to change the array dimension by changing the ROWS and COLS
        //below. This is to facilitate creating int array for any given dimensions so that the
        //values for arrays will be created in the below loop for testing purposes.

        int ROWS=4;
        int COLS=3;

        int [][] myCharArray = new int[ROWS][COLS];
        int val = 1;
        //Array values is populated using this loop for testing purposes. The integers starting from 1 to n
        // if ROWS=3, COLS=3
        //the array is populated with values
        //1 2 3
        //4 5 6
        //7 8 9

        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS ; col++)
            {
                myCharArray[row][col] = val;
                val++;
                //  System.out.println(myCharArray[row][col]+ " ");
            }

        }
        makeSprial(myCharArray);
    }

    public static boolean printVal(int a)
    {
        System.out.println (a);
        count++;
        return true;
    }
    public static void makeSprial (int[][] a)
    {
        int minRows = 0;
        int maxRows= a.length;

        int minCols=0;
        int maxCols=a[maxRows-1].length;

        int totalLength = maxRows * maxCols;
        boolean minRowsFlag=true;
        boolean minColsFlag=true;
        boolean maxColsFlag=false;
        boolean maxRowsFlag=false;

        while (count<totalLength)
        {
            if(minRowsFlag && minColsFlag && count<totalLength)
            {
                incrementCols(a, minRows, minCols, maxCols);
                minColsFlag = false;
                maxColsFlag = true;
                minRows++;
            }

            if(minRowsFlag && maxColsFlag && count<totalLength)
            {
                incrementRows(a, minRows, maxRows, maxCols-1);
                minRowsFlag = false;
                maxRowsFlag= true;
                maxCols--;

            }

            if (maxRowsFlag && maxColsFlag && count<totalLength)
            {
                decrementCols(a, maxRows-1, maxCols-1, minCols);
                maxColsFlag= false;
                minColsFlag= true;
                maxRows--;
            }

            if (maxRowsFlag && minColsFlag && count<totalLength)
            {
                decrementRows(a, maxRows-1, minRows, minCols);
                maxRowsFlag = false;
                minRowsFlag= true;
                minCols++;
            }
        }


    }

    public static void decrementRows(int[][] a, int FromRowNo, int minRowNo, int colNo)
    {

        for(int i=FromRowNo; i>=minRowNo; i--)
        {
            printVal(a[i][colNo]);
        }
    }

    public static void decrementCols(int[][] a, int rowNo, int FromColNo, int minColNo)
    {
        for(int i=FromColNo; i>=minColNo; i--)
        {
            printVal(a[rowNo][i]);
        }
    }

    public static void incrementCols(int[][] a, int rowNo, int FromColNo, int MaxColNo)
    {
        for(int i=FromColNo; i<MaxColNo; i++)
        {
            printVal(a[rowNo][i]);
        }
    }

    public static void incrementRows(int[][] a, int FromRowNo, int maxRowNo, int colNo)
    {

        for(int i=FromRowNo; i<maxRowNo; i++)
        {
            printVal(a[i][colNo]);
        }
    }

}
