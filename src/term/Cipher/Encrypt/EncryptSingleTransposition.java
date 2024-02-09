package term.Cipher.Encrypt;

import javax.crypto.Cipher;

import term.Cipher.Encrypt.Encrypt;
import term.Key.Key;
import term.Text.Ciphertext;
import term.Text.Plaintext;

import term.Grid.*;

public class EncryptSingleTransposition implements Encrypt {
  Key key;

  public EncryptSingleTransposition(Key key) {
    this.key = key;
  }

  public static Ciphertext encrypt(Plaintext plaintext, Key key) {
    EncryptSingleTransposition EST = new EncryptSingleTransposition(key);
    return EST.encrypt(plaintext);
  }

  @Override
  public Ciphertext	encrypt(Plaintext plaintext) {

    //create a grid and store plaintext in it
    Grid grid = new Grid(key.getKey().length(), plaintext.getText());
    String ciphertextStr = "";

    //iterate in increasing order
    for (int order = 0; order < key.getKey().length() - 1; ++order) {
      //find the column index of that order
      int colIndex = key.getKey().indexOf(order);
      //add that column from the grid to the ciphertext
      ciphertextStr += grid.getCol(colIndex);
    }

    return new Ciphertext(ciphertextStr);
  }

}
