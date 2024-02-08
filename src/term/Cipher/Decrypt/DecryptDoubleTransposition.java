package term.Cipher.Decrypt;

import term.Cipher.Decrypt.Decrypt;
import term.Text.Ciphertext;
import term.Text.Plaintext;
import term.Key.Key;

public class DecryptDoubleTransposition implements Decrypt{
  private Key key1;
  private Key key2;

  public DecryptDoubleTransposition(Key key1, Key key2) {
    this.key1 = key1;
    this.key2 = key2;
  }

  public static Plaintext decrypt(Ciphertext encryptedText, Key key1, Key key2) {
    // Add your decryption logic here
    return null;
  }
  
  public Plaintext decrypt(Ciphertext encryptedText){
    return null;
  }
}
