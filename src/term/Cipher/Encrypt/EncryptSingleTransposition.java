package term.Cipher.Encrypt;

import term.Cipher.Encrypt.Encrypt;
import term.Key.Key;
import term.Text.Ciphertext;
import term.Text.Plaintext;

public class EncryptSingleTransposition implements Encrypt {
  Key key;

  public EncryptSingleTransposition(Key key) {
    this.key = key;
  }

  public static Ciphertext encrypt(Plaintext plaintext, Key key) {
    // Add your encryption logic here
    return null;
  }
  @Override
  public Ciphertext	encrypt(Plaintext plaintext){    // Implement the encryption logic for single transposition cipher here
    // Return the encrypted ciphertext
    return null;
  }

}
