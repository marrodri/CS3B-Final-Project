package term.Key;

public class IntKey extends Key{
  final int[] ToRead;
  
  public IntKey(String keyString)
  {
    super(keyString);
    this.ToRead = KeyFun.orderOfIntKey(keyString);
  }
  
  public int indexOf(int order)
  {
    return ToRead[order];
  }
}
