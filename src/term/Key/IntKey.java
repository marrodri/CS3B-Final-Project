package term.Key;

public class IntKey extends Key{
  final int[] ToRead;
  final String orderKey;

  public IntKey(String keyString)
  {
    super(keyString);
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
