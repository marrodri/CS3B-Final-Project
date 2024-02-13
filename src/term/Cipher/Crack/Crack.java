package term.Cipher.Crack;

import term.Text.Ciphertext;

public interface Crack {
  //Crack the ciphertext and return the result in string
  public String crack(Ciphertext ciphertext);
  //Return the number of attempts in cracking the ciphertext
  public int getAttempts();
}
