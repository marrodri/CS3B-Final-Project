package term.Cipher.Decrypt;

import term.Cipher.Encrypt.Encrypt;
import term.Cipher.Encrypt.EncryptDoubleTransposition;
import term.Grid.Grid;
import term.Text.*;
import term.Key.*;


public class DecryptDoubleTransposition implements Decrypt{
  //First key which is used first in encrypting
  private Key keyFirst;
  //Second key which is used later in encrypting
  private Key keyLater;

  //Main method for testing
  public static void main(String[] args) {
    Plaintext plaintext = new Plaintext("Hello_World,_but_it_is_becoming_a_larger_and_larger_world.");
    // Key key1 = new LetterKey("DAY");
    // Key key2 = new LetterKey("EIDKSJAGB");
    Key key1 = Key.RandomIntKey(10);
    Key key2 = Key.RandomLetterKey(10);
    System.out.println("Key1: " + key1);
    System.out.println("Key2: " + key2);
    System.out.println();

    Ciphertext ciphertext = EncryptDoubleTransposition.encrypt(plaintext, key1, key2);
    
    System.out.println("Plaintext: \n\t" + plaintext);
    System.out.println("Ciphertext: \n\t" + ciphertext);
    System.out.println();

    Plaintext result = DecryptDoubleTransposition.decrypt(ciphertext, key1, key2);
    System.out.println("Result: \n\t" + result);
    System.out.println("Ciphertext: \n\t" + ciphertext);

    int trials = 100000;
    System.out.println(String.format("\n\nTesting %d trials...\n\n", trials));
    long startTime = System.nanoTime();

    for(int i = 0; i < trials; i++){
      key1 = Key.RandomIntKey(10);
      key2 = Key.RandomLetterKey(10);
      ciphertext = EncryptDoubleTransposition.encrypt(plaintext, key1, key2);
      result = DecryptDoubleTransposition.decrypt(ciphertext, key1, key2);
      if(!plaintext.equals(result)){
        System.out.println("Failed at " + i + "th trial");
        System.out.println("Plaintext: \n\t" + plaintext);
        System.out.println("Ciphertext: \n\t" + ciphertext);
        System.out.println("Result: \n\t" + result);
        break;
      }
    }
    System.out.println("Done!");
    System.out.println("Time: " + (System.nanoTime() - startTime) / 1000000 + "ms");
    System.out.println("For plaintext length: " + plaintext.length() + " and " + trials + " trials");
  }

  //-------------------------Public Interface------------------------------------------------------
  //Constructor
  public DecryptDoubleTransposition(Key KeyFirst, Key KeyLater) {
    this.keyFirst = KeyFirst;
    this.keyLater = KeyLater;
  }

  //Static method for decrypting
  public static Plaintext decrypt(Ciphertext encryptedText, Key keyFirst, Key keyLater) {
    // Add your decryption logic here
    return new DecryptDoubleTransposition(keyFirst, keyLater).decrypt(encryptedText);
  }
  
  //decrypt the encrypted text
  public Plaintext decrypt(Ciphertext encryptedText){
    Grid plaintextGrid = inverseDoubleTransposition(encryptedText, keyFirst, keyLater);
    String plaintext = DecryptSingleTransposition.
      rStripFillChar(KeyFun.listToKeyStr( plaintextGrid.getGridArray()) , Grid.fillChar);
    
    return new Plaintext(plaintext);
  }

  //Getter for keyFirst and keyLater
  public Key getKeyFirst() {
    return keyFirst;
  }

  public Key getKeyLater() {
    return keyLater;
  }

  //------------------Private/Protected Helper Functions--------------------------------------------------------------

  
  //@returns the form of a grid of the plaintext
  static Grid inverseDoubleTransposition(Ciphertext encryptedText, Key keyFirst, Key keyLater) {
  // Decrypting Double Transposition is the same as decrypting twice with the single transposition
  //Socks Shoes (Encrypting) and Shoes Socks principle (Decrypting)
    
    //First take off the shoes : the last key used in encrypting
    Ciphertext ciphertext = new Ciphertext(DecryptSingleTransposition.decrypt(encryptedText, keyLater).toString());

    //Then take off the socks : the first key used in encrypting
    Grid plaintextGrid = DecryptSingleTransposition.inverseSingleTransposition(ciphertext, keyFirst);

    return plaintextGrid;
  }
}
