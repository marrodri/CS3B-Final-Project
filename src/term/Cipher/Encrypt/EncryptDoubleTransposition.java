package term.Cipher.Encrypt;

import term.Cipher.Encrypt.Encrypt;
import term.Key.Key;
import term.Text.Ciphertext;
import term.Text.Plaintext;

public class EncryptDoubleTransposition implements Encrypt {
  Key key1;
  Key key2;

  public EncryptDoubleTransposition(Key key1, Key key2) {
    this.key1 = key1;
    this.key2 = key2;
  }

  public static Ciphertext encrypt(Plaintext plaintext, Key key1, Key key2) {
    // Add your encryption logic here
    return null;
  }
  
  @Override
  public Ciphertext	encrypt(Plaintext plaintext){    // Implement the encryption logic for single transposition cipher here
    // Return the encrypted ciphertext
    return null;
  }

}
