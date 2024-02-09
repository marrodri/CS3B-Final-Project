package term.Cipher.Decrypt;

import term.Grid.Grid;
import term.Text.Ciphertext;
import term.Text.Plaintext;
import term.Key.Key;
import term.Key.KeyFun;
import term.Key.LetterKey;

public class DecryptSingleTransposition implements Decrypt{
  private final Key key;
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
  }
  
  public Key getKey() {
    return key;
  }

  public Plaintext decrypt(Ciphertext encryptedText){
    Grid plaintextGrid = inverseSingleTransposition(encryptedText, key);

    return new Plaintext( KeyFun.listToKeyStr( plaintextGrid.getGridArray() ).replaceAll("\\*", "") );
  }

  static Grid inverseSingleTransposition(Ciphertext encryptedText, Key key) {
    int keyLen = key.getKeyLen();
    int cipherTextLen = encryptedText.length();
    Grid inversedGrid = new Grid(KeyFun.getRowLen(keyLen, cipherTextLen), encryptedText.getText());
    Grid plaintextGrid = new Grid(keyLen, encryptedText.getText());

    for(int i = 0; i < inversedGrid.getRowCount(); i++)
    {
      int colToPlace = key.indexOf(i);
      plaintextGrid.replaceCol(inversedGrid.getRow(i), colToPlace);
    }
    return plaintextGrid;
  }

  //--------------------------------------------------------------------------------
  
}