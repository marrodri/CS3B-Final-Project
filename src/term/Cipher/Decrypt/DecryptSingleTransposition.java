package term.Cipher.Decrypt;

import term.Cipher.Decrypt.Decrypt;
import term.Grid.Grid;
import term.Text.Ciphertext;
import term.Text.Plaintext;
import term.Key.Key;
import term.Key.KeyFun;
import term.Key.LetterKey;

public class DecryptSingleTransposition implements Decrypt{
  private final Key key;
  private final int[] orderToRead;
  public static void main(String[] args) {
    System.out.println(decrypt(new Ciphertext("eoodHlWll_r*"), new LetterKey("DAY")));
  }

  //--------------------------------------------------------------------------------
  public static Plaintext decrypt(Ciphertext encryptedText, Key key) {
    // Add your decryption logic here
    return new DecryptSingleTransposition(key).decrypt(encryptedText);
  }
  //--------------------------------------------------------------------------------
  public DecryptSingleTransposition(Key key) {
    this.key = key;
    this.orderToRead = KeyFun.orderOfIntKey(key.toString());
  }
  
  public Key getKey() {
    return key;
  }

  public Plaintext decrypt(Ciphertext encryptedText){
    int keyLength = key.getKeyLen();
    int textLength = encryptedText.length();
    Grid inversedGrid = new Grid(KeyFun.getRowLen(keyLength, textLength), encryptedText.getText());
    Grid plaintextGrid = new Grid(keyLength, encryptedText.getText());

    for(int i = 0; i < inversedGrid.getRowCount(); i++)
    {
      int colToPlace = key.indexOf(i);
      plaintextGrid.replaceCol(inversedGrid.getRow(i), colToPlace);
    }

    return new Plaintext(KeyFun.listToKeyStr(plaintextGrid.getGridArray()));
  }

  //--------------------------------------------------------------------------------
  
}