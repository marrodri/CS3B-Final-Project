package term.Cipher.Decrypt;

import term.Text.Ciphertext;
import term.Text.Plaintext;

public interface Decrypt {
  public Plaintext decrypt(Ciphertext encryptedText);
}
