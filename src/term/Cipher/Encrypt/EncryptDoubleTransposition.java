package term.Cipher.Encrypt;

import term.Key.*;
import term.Text.*;


public class EncryptDoubleTransposition implements Encrypt {
  Key key1;
  Key key2;


  public EncryptDoubleTransposition(Key key1, Key key2) {
    this.key1 = key1;
    this.key2 = key2;
  }

  //static method for encrypting
  public static Ciphertext encrypt(Plaintext plaintext, Key key1, Key key2) {
    EncryptDoubleTransposition edt = new EncryptDoubleTransposition(key1, key2);
    return edt.encrypt(plaintext);
  }
  
  //Encrypt the plaintext
  @Override
  public Ciphertext	encrypt(Plaintext plaintext) {    
    EncryptSingleTransposition once = new EncryptSingleTransposition(key1);
    Plaintext onceEncrypted = new Plaintext(once.encrypt(plaintext).getText());
    EncryptSingleTransposition twice = new EncryptSingleTransposition(key2);
    return twice.encrypt(onceEncrypted);
  }

}
