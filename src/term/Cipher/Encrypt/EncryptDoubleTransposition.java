package term.Cipher.Encrypt;

import term.Cipher.Encrypt.Encrypt;
import term.Key.Key;
import term.Text.Ciphertext;
import term.Text.Plaintext;

public class EncryptDoubleTransposition implements Encrypt {
  Key key1;
  Key key2;

  public EncryptDoubleTransposition(Key key1, Key key2) {
    this.key1 = key1;
    this.key2 = key2;
  }

  public static Ciphertext encrypt(Plaintext plaintext, Key key1, Key key2) {
    EncryptDoubleTransposition EDT = new EncryptDoubleTransposition(key1, key2);
    return EDT.encrypt(plaintext);
  }
  
  @Override
  public Ciphertext	encrypt(Plaintext plaintext) {    
    EncryptSingleTransposition once = new EncryptSingleTransposition(key1);
    Plaintext onceEncrypted = new Plaintext(once.encrypt(plaintext).getText());
    EncryptSingleTransposition twice = new EncryptSingleTransposition(key2);
    return twice.encrypt(onceEncrypted);
  }

}
