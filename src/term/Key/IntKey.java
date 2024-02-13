package term.Key;

public class IntKey extends Key{
  private final int[] ToRead;
  private final String orderKey;

  //The key is a string of numbers from 0 to 9 (non-repeating)
  //Max length of the key is 10
  public IntKey(String keyString)
  {
    super(keyString);
    
    if(keyString.length() > 10)
    {
      throw new IllegalArgumentException("Key length must be less than 10");
    }

    //Convert the key to an array of look up table for reading column order
    this.ToRead = KeyFun.orderOfIntKey(keyString);
    //Turning the look up table back to a string key
    this.orderKey = KeyFun.intArrToStr(ToRead);
  }
  
  //Return the index of the order
  public int indexOf(int order)
  {
    return ToRead[order];
  }

  //Return the order key as a string
  public String getKey()
  {
    return this.orderKey;
  }
}
