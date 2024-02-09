package term.Key;

import term.Random;
public class Key{

  private String key; // String is immutable 

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
  public Key(String key) {
    this.key = key;
  }

  public static Key RandomIntKey(int len) {
    // Add code to generate a random key with the specified number of characters
    // Assign the generated key to the 'key' variable

    StringBuilder k = new StringBuilder();
    for (int i = 0; i < len; i++) {
      k.append(String.valueOf(Random.nextInt(10)));
    }
    return new Key(k.toString());
  }
  
  public static Key RandomLetterKey(int len) {
    // Add code to generate a random key with the specified number of characters
    // Assign the generated key to the 'key' variable
    StringBuilder k = new StringBuilder();
    for (int i = 0; i < len; i++) {
      k.append(Random.nextLetter());
    }
    return new Key(k.toString());
  }
  public String getKey() {
    return key;
  }

  @Override
  public String toString() {
    return key;
  }
}

