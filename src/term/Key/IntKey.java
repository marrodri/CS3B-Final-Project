package term.Key;

public class IntKey extends Key{
  final int[] ToRead;
  final String orderKey;

  public IntKey(String keyString)
  {
    super(keyString);
    
    if(keyString.length() > 10)
    {
      throw new IllegalArgumentException("Key length must be less than 10");
    }

    this.ToRead = KeyFun.orderOfIntKey(keyString);
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
