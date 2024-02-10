package term.Key;
//From Benchmark Ben, very powerful, very useful

import java.util.ArrayList;

public class KeyFun {
  public static void main(String[] args) {
    System.out.println("Order of 927345: ");
    for(int i : orderOfIntKey("927345"))
    {
      System.out.println(i + " " + "927345".charAt(i));
    }
    System.out.println();

    String key1 = "345012";
    System.out.println("Order of " + key1);
    for(int i : orderOfIntKey(key1))
    {
      System.out.println(i + " " + key1.charAt(i));
    }
    System.out.println();

    String letterKey = "babybabyOH";
    String key2 = alphabeticalToNumeric(letterKey);
    System.out.println("Alphabetical to Numeric: " + letterKey + " -> " + key2);
    System.out.println("Order of " + key2);
    for(int i : orderOfIntKey(key2))
    {
      System.out.println(i + " " + key2.charAt(i));
    }
  }

  //function assumes alphabeticalKey contains 10 characters or fewer
  //and has no special characters or spaces. But alphabeticalKey
  //can be any combination of upper and lower case characters.
  public static String alphabeticalToNumeric(String alphabeticalKey) {
    alphabeticalKey = alphabeticalKey.toUpperCase();
    char[] numericKey = alphabeticalKey.toCharArray();
    int replaced = 0;

    for (int letter = 0; replaced < alphabeticalKey.length() && letter <= 25 ; ++letter) {
        for (int i = 0; i < alphabeticalKey.length(); ++i) {
            if (numericKey[i] == (char)(letter + 65)) {
                numericKey[i] = Character.forDigit(replaced, 10);
                ++replaced;
            }
        }
    }
    return String.valueOf(numericKey);
  }

  //Makes ArrayList into a string 
  public static <T> String listToKeyStr(ArrayList<T> list) {
    //array list to key string
    String listK = list.toString().replaceAll(", ", "").replace("[", "").replace("]", "");
    
    return listK;
  }

  public static int getRowLen(int col_len, int text_len) {
    return Math.ceilDiv(text_len, col_len);
  }
  
  public static String intArrToStr(int[] arr)
  {
    String ret = "";
    for(int i = 0; i < arr.length; i++)
    {
      ret += String.valueOf(arr[i]);
    }
    return ret;
  }
  //Assuming the key is all numbers ranging from 0 to 9 and have no repeating numbers
  //#######//
  public static int[] orderOfIntKey(String intKeyStr)
  {
    int[] order = new int[intKeyStr.length()];

    order[0] = minIndex(intKeyStr);
    for(int i = 1; i < intKeyStr.length(); i++)
    {
      order[i] = minimumButBiggerThan(intKeyStr, order[i - 1]);
    }

    return order;
  }

  //@Return the index of The SMALLEST number in the key
  private static int minIndex(String intKeyStr)
  {
    int index = 0;
    for(int i = 0; i < intKeyStr.length(); i++)
    {
      if(intKeyStr.charAt(i) < intKeyStr.charAt(index))
      {
        index = i;
      }
    }

    return index;
  }
  //@Return the index of the SMALLEST number in the key that is bigger than the number at index
  private static int minimumButBiggerThan(String intKeyStr, int index)
  {
    int ret = -1;
    for(int i = 0; i < intKeyStr.length(); i++)
    {
      if( ( intKeyStr.charAt(i) > intKeyStr.charAt(index) ) && 
            ( ret == -1 || intKeyStr.charAt(i) < intKeyStr.charAt(ret) ) )
      {
        ret = i;
      }
    }

    return ret;
  }
  //------//

}
