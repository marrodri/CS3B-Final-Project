package term.Cipher.Encrypt;

import term.Key.*;
import term.Text.*;
import term.Grid.*;

public class EncryptSingleTransposition implements Encrypt {
  Key key;

  public EncryptSingleTransposition(Key key) {
    this.key = key;
  }

  //static method for encrypting
  public static Ciphertext encrypt(Plaintext plaintext, Key key) {
    EncryptSingleTransposition est = new EncryptSingleTransposition(key);
    return est.encrypt(plaintext);
  }

  //Encrypt the plaintext
  @Override
  public Ciphertext	encrypt(Plaintext plaintext) {
    //create a grid and store plaintext in it
    Grid grid = new Grid(key.getKey().length(), plaintext.getText());
    String ciphertextStr = "";

    //iterate in increasing order
    for (int order = 0; order < key.getKey().length(); ++order) {
      //find the column index of that order
      int colIndex = key.indexOf(order);
      //add that column from the grid to the ciphertext
      ciphertextStr += grid.getCol(colIndex);
    }

    return new Ciphertext(ciphertextStr);
  }

}
