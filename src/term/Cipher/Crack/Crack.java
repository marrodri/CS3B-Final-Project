package term.Cipher.Crack;

import term.Text.Ciphertext;

public interface Crack {
  public String crack(Ciphertext ciphertext);
  public int getAttempts();
}
