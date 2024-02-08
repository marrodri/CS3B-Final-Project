package term.Key;

public class Key{

  private String key; // String is immutable 

  public String getKey() {
    return key;
  }

  public Key(String key) {
    this.key = key;
  }

  public static Key generateRandomKey(int numberOfChars) {
    // Add code to generate a random key with the specified number of characters
    // Assign the generated key to the 'key' variable

    return null;
  }

  @Override
  public String toString() {
    return key;
  }
}