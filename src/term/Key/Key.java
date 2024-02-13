package term.Key;

import java.util.ArrayList;
import term.Random;

public abstract class Key{
  private final String keyStr; // key is immutable 
  
  //Non repeated random number from 0 to 9
  public static Key RandomIntKey(int len) {
    // Add code to generate a random key with the specified number of characters
    if(len > 10)
    {
      len = 10;
    }
    else if (len < 5)
    {
      len = 5;
    }


    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < len; i++) {
      int r = Random.nextInt(10);
      if(!list.contains(r))
      {
        list.add(r);
      }
      else
      {
        i--;
      }
    }
    
     
    return new LetterKey(KeyFun.<Integer>listToKeyStr(list));
  }

  //Repeated random letter from a to z
  public static Key RandomLetterKey(int len) {
    // Add code to generate a random key with the specified number of characters
    // Assign the generated key to the 'key' variable
    StringBuilder k = new StringBuilder();
    for (int i = 0; i < len; i++) {
      k.append(Random.nextLetter());
    }
    return new LetterKey(k.toString());
  }
  
  public static void main(String[] args) {
    int loops = 5;
    int len = 10;
    System.out.println("\nRandom Int Key\n");
    for(int i = 0; i < loops; i++) {
      System.out.println(Key.RandomIntKey(len));
    }

    System.out.println("\nRandom Letter Key\n");
    for(int i = 0; i < loops; i++) {
      System.out.println(Key.RandomLetterKey(len));
    }
  }

  //return the index of column readin based on order (first to read is 0, and last to read is len-1) 
  public abstract int indexOf(int order);

  //return the key representing the reading order
  public abstract String getKey();

  //--------------------------------------------------------------------------------

  public Key(String key) {
    this.keyStr = key;
  }

  //return the original string
  //(that is not the actual Key)
  public String getKeyStr() {
    return keyStr;
  }

  public int getKeyLen() {
    return keyStr.length();
  }

  @Override
  public boolean equals(Object key2) {
    if(!(key2 instanceof Key)) {
      return false;
    }
    return keyStr.equals(((Key)key2).getKeyStr());
  }

  @Override
  public String toString() {
    return keyStr;
  }

  //--------------------------------------------------------------------------------


}

