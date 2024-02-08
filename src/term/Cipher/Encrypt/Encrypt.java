package term.Cipher.Encrypt;

import term.Text.Ciphertext;
import term.Text.Plaintext;

public interface Encrypt {
  public Ciphertext	encrypt(Plaintext plaintext);
}
