package term.Cipher.Encrypt;

import term.Key.*;
import term.Text.*;
import term.Grid.*;

public class EncryptSingleTransposition implements Encrypt {
  Key key;
  public static void main(String[] args) {
    System.out.println(encrypt(new Plaintext("Hello_World"), new LetterKey("DAY")));
  
  }

  public EncryptSingleTransposition(Key key) {
    this.key = key;
  }

  public static Ciphertext encrypt(Plaintext plaintext, Key key) {
    EncryptSingleTransposition est = new EncryptSingleTransposition(key);
    return est.encrypt(plaintext);
  }

  @Override
  public Ciphertext	encrypt(Plaintext plaintext) {
    //create a grid and store plaintext in it
    Grid grid = new Grid(key.getKey().length(), plaintext.getText());
    String ciphertextStr = "";

    //iterate in increasing order
    for (int order = 0; order < key.getKey().length(); ++order) {
      //find the column index of that order
      int colIndex = key.getKey().indexOf('0' + order);
      //add that column from the grid to the ciphertext
      ciphertextStr += grid.getCol(colIndex);
    }

    return new Ciphertext(ciphertextStr);
  }

}
