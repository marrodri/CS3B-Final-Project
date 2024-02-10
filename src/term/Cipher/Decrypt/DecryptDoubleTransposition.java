package term.Cipher.Decrypt;

import term.Cipher.Decrypt.DecryptSingleTransposition;
import term.Grid.Grid;
import term.Text.*;
import term.Key.*;


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
    String plaintext = DecryptSingleTransposition.
      rStripFillChar(KeyFun.listToKeyStr( plaintextGrid.getGridArray()) , Grid.fillChar);
    
    return new Plaintext(plaintext);
  }

  //--------------------------------------------------------------------------------

  
  //@returns the form of a grid of the plaintext
  static Grid inverseDoubleTransposition(Ciphertext encryptedText, Key keyFirst, Key keyLater) {
  // Decrypting Double Transposition is the same as decrypting twice with the single transposition
  //Socks Shoes (Encrypting) and Shoes Socks principle (Decrypting)
    
    //First take off the shoes : the last key used in encrypting
    Ciphertext ciphertext = new Ciphertext(DecryptSingleTransposition.decrypt(encryptedText, keyLater).toString());

    //Then take off the socks : the first key used in encrypting
    Grid plaintextGrid = DecryptSingleTransposition.inverseSingleTransposition(ciphertext, keyFirst);

    return plaintextGrid;
  }
}
