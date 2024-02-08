package term.Cipher.Decrypt;

import term.Cipher.Decrypt.Decrypt;
import term.Text.Ciphertext;
import term.Text.Plaintext;
import term.Key.Key;

public class DecryptSingleTransposition implements Decrypt{
  private Key key;

  public DecryptSingleTransposition(Key key) {
    this.key = key;
  }
  public static Plaintext decrypt(Ciphertext encryptedText, Key key) {
    // Add your decryption logic here
    return null;
  }
  
  public Plaintext decrypt(Ciphertext encryptedText){
    return null;
  }
}