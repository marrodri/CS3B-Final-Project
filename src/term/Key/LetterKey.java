package term.Key;

public class LetterKey extends Key{
  private final int[] ToRead;
  private final String orderKey;

  public LetterKey(String keyString)
  {
    super(keyString);
    if(keyString.length() > 10)
    {
      throw new IllegalArgumentException("Key length must be less than 10");
    }

    this.ToRead = KeyFun.orderOfIntKey(KeyFun.alphabeticalToNumeric(keyString));
    this.orderKey = KeyFun.intArrToStr(ToRead);
  }
  
  public int indexOf(int order)
  {
    return ToRead[order];
  }

  public String getKey()
  {
    return this.orderKey;
  }
}
