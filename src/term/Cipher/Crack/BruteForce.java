package term.Cipher.Crack;

import term.Text.Ciphertext;
import term.Text.Plaintext;


//A super class that is intended to be extended by all brute force cracking classes
public class BruteForce implements Crack{
  protected int attempts = 0;

  public String crack(Ciphertext ciphertext){
    // internally empty
    return null;
  }

  public int getAttempts(){
    return attempts;
  }
}
