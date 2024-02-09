package term.Key;

public class LetterKey extends Key{
  final int[] ToRead;
  
  public LetterKey(String keyString)
  {
    super(keyString);
    this.ToRead = KeyFun.orderOfIntKey(KeyFun.alphabeticalToNumeric(keyString));
  }
  
  public int indexOf(int order)
  {
    return ToRead[order];
  }
}
