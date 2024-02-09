package term.Cipher.Decrypt;

import term.Cipher.Decrypt.DecryptSingleTransposition;
import term.Text.Ciphertext;
import term.Text.Plaintext;
import term.Grid.Grid;
import term.Key.Key;
import term.Key.KeyFun;

public class DecryptDoubleTransposition implements Decrypt{
  //First key which is used first in encrypting
  private Key keyFirst;
  //Second key which is used later in encrypting
  private Key keyLater;

  public DecryptDoubleTransposition(Key KeyFirst, Key KeyLater) {
    this.keyFirst = KeyFirst;
    this.keyLater = KeyLater;
  }

  public static Plaintext decrypt(Ciphertext encryptedText, Key keyFirst, Key keyLater) {
    // Add your decryption logic here
    return new DecryptDoubleTransposition(keyFirst, keyLater).decrypt(encryptedText);
  }
  
  public Plaintext decrypt(Ciphertext encryptedText){
    Grid plaintextGrid = inverseDoubleTransposition(encryptedText, keyFirst, keyLater);

    return new Plaintext( KeyFun.listToKeyStr( plaintextGrid.getGridArray() ).replaceAll("\\*", "") );
  }

  static Grid inverseDoubleTransposition(Ciphertext encryptedText, Key keyFirst, Key keyLater) {
    // Decrypting Double Transposition is the same as decrypting twice with the single transposition
    Grid ciphertextGrid = DecryptSingleTransposition.inverseSingleTransposition(encryptedText, keyLater);
    Ciphertext ciphertext = new Ciphertext( KeyFun.listToKeyStr( ciphertextGrid.getGridArray() ));
    Grid plaintextGrid = DecryptSingleTransposition.inverseSingleTransposition(ciphertext, keyFirst);

    return plaintextGrid;
  }
}
