//Powered by Coffee and Coding, and CYLee
package term.Permutations;

public class Permutations {
  protected int SET_SIZE = 10; //number of digits from 0-9
  private int count = 0; //The number of permutations generated
  private boolean isDone;

  int[] permutations; // 1D array to store pointers to the current row of the 2D array
  int[] remainingSet; // 1D array to store the remaining set of numbers
  
  public static void main(String[] args) //Demonstration of the Permutations class
  {
    Permutations p = new Permutations(4);
    String targetNum = "0321";
    while(!p.isDone())
    {
      String num = p.next();
      if(num.compareTo(targetNum) == 0)
      {
        System.out.println( targetNum + " is found");
        System.out.println("Found at : " + p.getCount());
      }
    }

    System.out.println();

    int Expected = 10*9*8*7;
    System.out.println("Expected count : " + Expected);
    System.out.println("Actual count: " + p.getCount());
  }

  public Permutations(int len)
  {
    isDone = false;
    count = 0;
    permutations = new int[len];
    remainingSet = new int[SET_SIZE - len];

    for(int i = 0; i < len; i++)
    {
      permutations[i] = i;
    }

    for(int i = 0; i < SET_SIZE - len; i++)
    {
      remainingSet[i] = len + i;
    }
  }

  public String next()
  {
    StringBuilder stringBuilder = new StringBuilder();

    for(int i = 0; i < permutations.length; i++)
    {
      stringBuilder.append(String.valueOf(permutations[i]));
    }
    
    swappingDigit(permutations.length - 1);
    count++;
    return stringBuilder.toString();
  }

  public boolean isDone()
  {
    return isDone;
  }

  public int getCount()
  {
    return count;
  }

  //***call After getting a permutation, and it updates the digit at i to get the next permutation
  //@param i the index of the pointer to be swapped
  // If the digit cannot be swapped with any of the remaining set or any successing digit, then it wraps up
  private void swappingDigit(int i)
  {
    //  swap the pointer with elements in remaining set
    //  whcih is bigger than the current pointer and smallest among all.

    int swapIndex = lookForBigger(i);

    if(swapIndex != -1) //bigger is found
    {
      swapWith(i, swapIndex);
    }
    else
    {
      //  If it cannot swap with the remaining set, it is wrapping up
      wrapUp(i);
    }
  
  }

  //***call after swap fail, and it updates the digit at i also at i - 1 
  //@param i the index of the pointer to be wrapped up
  private void wrapUp(int i)
  { 
  //  Wrap around
    //  If it tries to wrap up the first element, then we are done
    if(i == 0)
    {
      isDone = true;
      return;
    }
    else
    {
      //First Update the previous digit
      swappingDigit(i - 1);
      //  then swap itself with the smalles element in the remaining set or in the successor set
      int swapIndex = lookForSmallest(i);
      if(swapIndex != -1) // if the smallest number is found
        swapWith(i, swapIndex);
    }
  }


//Both look for bigger and look for smallest are finding number in the remaining set and the successor set
  //Look for bigger is finding the number that is bigger than the current digit but smallest among both sets 
  private int lookForBigger(int cur)
  {
    int result = -1; //-1 means no number is found

    //search in the remaining set
    for(int i = 0; i < remainingSet.length; i++)
    {
      //If the number is bigger than the current digit
      if(remainingSet[i] > permutations[cur])
      {
        if(result == -1) //If no number is found yet
        {
          result = i;
        }
        else if(remainingSet[i] < remainingSet[result]) //if the number is smaller than the previous number found
        {
          result = i;
        }
      }
    }
    
    //search in the successor set
    for(int i = cur + 1; i < permutations.length; i++)
    {
      if(permutations[i] > permutations[cur]) 
      {
        if(result == -1 
          || ((result >= remainingSet.length) && (permutations[i] < permutations[result - remainingSet.length]))  
          || ((result < remainingSet.length) && (permutations[i] < remainingSet[result]))
        )
          result = i + remainingSet.length;
      }
    }
    return result;
  }
  
  //Look for smallest is finding the number that is the smallest among both sets
  private int lookForSmallest(int cur)
  {
    int result = -1;
    for(int i = 0; i < remainingSet.length; i++)
    {
      if(result == -1)
      {
        result = i;
      }
      else if(remainingSet[i] < remainingSet[result])
      {
        result = i;
      }
    }

    if(result == -1)
      for(int i = cur + 1; i < permutations.length; i++)
      {
        if((permutations[i] < permutations[cur])
        &&(
            result == -1 
            || ((result >= remainingSet.length) && (permutations[i] < permutations[result - remainingSet.length])))
        ) result = i + remainingSet.length;  
      }
    return result;
  }
  
  //swap the current digit with the digit at swapIndex
  private void swapWith(int i, int swapIndex) {
    //  swap the numbers
    int temp = permutations[i];
    
    //The digit to be swapped is in the remaining set
    if(swapIndex < remainingSet.length)
    {
      permutations[i] = remainingSet[swapIndex];
      remainingSet[swapIndex] = temp;
    }
    //The digit to be swapped is in the successor set
    else
    {
      permutations[i] = permutations[swapIndex - remainingSet.length];
      permutations[swapIndex - remainingSet.length] = temp;
    }
  }

  //Debugging functions
  private void printPermute()
  {
    System.out.print("Permutation:s ");
    for(int i = 0; i < permutations.length; i++)
    {
      System.out.print(permutations[i] + " ");
    }
    System.out.println();
  }

  private void printRemainingSet()
  {
    System.out.print("Remaining Set: ");
    for(int i = 0; i < remainingSet.length; i++)
    {
      System.out.print(remainingSet[i] + " ");
    }
    System.out.println();
  }

}
