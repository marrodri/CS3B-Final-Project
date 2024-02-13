package term.Cipher.Encrypt;

import term.Text.Ciphertext;
import term.Text.Plaintext;

public interface Encrypt {
  //Encrypt the plaintext and return a ciphertext
  public Ciphertext	encrypt(Plaintext plaintext);
}
