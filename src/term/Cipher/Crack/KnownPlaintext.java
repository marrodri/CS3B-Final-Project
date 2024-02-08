package term.Cipher.Crack;

import term.Text.Ciphertext;
import term.Text.Plaintext;

public class KnownPlaintext extends BruteForce {
  Plaintext knownPlaintext;

  public KnownPlaintext(Plaintext knownPlaintext){
    this.knownPlaintext = knownPlaintext;
  }

  //It returns the key that was used to encrypt the known plaintext
  public String crack(Ciphertext ciphertext){
    // Implementation goes here
    //remeber to increment the attempts
    return null;
  }
}
