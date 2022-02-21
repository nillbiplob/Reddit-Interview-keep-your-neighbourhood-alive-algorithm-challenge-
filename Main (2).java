/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
  private int[][] input = { {0, 1, 1}, {1, 1, 1}, {1, 1, 0} };

  private int[][] output = { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} };

  private static int MAX = 3;



  public static void main (String[]args)
  {
    System.out.println ("Hello World");

    Main m = new Main ();
    m.startGame ();

    m.printOutput ();


  }

  private void startGame ()
  {

    for (int i = 0; i < MAX; i++)
      {
	for (int j = 0; j < MAX; j++)
	  {
	    // print input for better visualization
	    System.out.print (input[i][j] + "   ");

	    // get current  status

	    int currentValue = input[i][j];

	    // find all neighbour status


	    int[] nStatus = findNearByValue (i, j);

	    // match with all logics and store the updated value into the output array

	    output[i][j] = toggleNeighbourStatus (nStatus, currentValue);



	  }
	System.out.println ("\n");

      }






  }




  private int[] findNearByValue (int i, int j)
  {
    // find max 4  status of neighbour

    int[] n = { 0, 0, 0, 0 };


    if (i > 0)
      {
	n[0] = input[i - 1][j];
      }
    if (i < MAX - 1)
      {
	n[1] = input[i + 1][j];
      }


    if (j > 0)
      {
	n[2] = input[i][j - 1];
      }


    if (j < MAX - 1)
      {
	n[3] = input[i][j + 1];
      }



    return n;

  }

  private int toggleNeighbourStatus (int nStatus[], int selectedStatus)
  {
    // find max 4  status of neighbour

    int counter = 0;

    for (int i = 0; i < nStatus.length; i++)
      {

	if (nStatus[i] == 1)
	  {
	    counter++;
	  }

      }

    if (selectedStatus == 0 && counter < 2)
      {
	return 0;		// less 
      }
    else if (selectedStatus == 0 && counter >= 2)
      {
	return 1;		// perfect 
      }
    else if (selectedStatus == 1 && counter > 3)
      {
	return 0;		// over crowded
      }
    else if (selectedStatus == 1 && counter < 2)
      {
	return 0;		//  less
      }
    else if (selectedStatus == 1)
      {
	return 1;		// perfect
      }



    return 0;

  }


  private void printOutput ()
  {
    System.out.println ("\n Print Output........................");
    System.out.println ("\n");



    for (int i = 0; i < MAX; i++)
      {
	for (int j = 0; j < MAX; j++)
	  {
	    System.out.print (output[i][j] + "   ");

	  }
	System.out.println ("\n");

      }
  }
}
