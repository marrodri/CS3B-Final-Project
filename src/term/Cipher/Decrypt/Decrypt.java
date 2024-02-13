package term.Cipher.Decrypt;

import term.Text.Ciphertext;
import term.Text.Plaintext;

public interface Decrypt {
  //Decrypt the ciphertext and return a plaintext
  public Plaintext decrypt(Ciphertext encryptedText);
}
