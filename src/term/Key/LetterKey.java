package term.Key;

public class LetterKey extends Key{
  private final int[] ToRead;
  private final String orderKey;

  public LetterKey(String keyString)
  {
    super(keyString);
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
