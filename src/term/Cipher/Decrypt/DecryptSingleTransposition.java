package term.Cipher.Decrypt;

import term.Grid.Grid;
import term.Text.*;
import term.Key.*;
import term.Cipher.Encrypt.EncryptSingleTransposition;

public class DecryptSingleTransposition implements Decrypt{
  private final Key key;
  public static void main(String[] args) {
    System.out.println(decrypt(new Ciphertext("eoodHlWll_r*"), new LetterKey("DAY")));
    System.out.println();

    
    Key key = Key.RandomIntKey(10);
    System.out.println("Key: " + key);
    
    Plaintext plaintext = new Plaintext("Hello_World,_but_it_is_becoming_a_larger_and_larger_world.");
    Ciphertext ciphertext = EncryptSingleTransposition.encrypt(plaintext, key);
    
    System.out.println("Plaintext: \n\t" + plaintext);
    System.out.println("Ciphertext: \n\t" + ciphertext);

    Plaintext result = DecryptSingleTransposition.decrypt(ciphertext, key);
    System.out.println("Result: \n\t" + result);

  }

  //-------------------------Public Interface------------------------------------------------------
  //Constructor
  public DecryptSingleTransposition(Key key) {
    this.key = key;
  }
  
  //Decrypt the encrypted text
  public Plaintext decrypt(Ciphertext encryptedText){
    Grid plaintextGrid = inverseSingleTransposition(encryptedText, key);
    String plaintext = rStripFillChar(KeyFun.listToKeyStr( plaintextGrid.getGridArray()) , Grid.fillChar);
    return new Plaintext(plaintext);
  }

  //static method for decrypting
  public static Plaintext decrypt(Ciphertext encryptedText, Key key) {
    return new DecryptSingleTransposition(key).decrypt(encryptedText);
  }

  //Getter
  public Key getKey() {
    return key;
  }

  //------------------Private/Protected Helper Functions--------------------------------------------------------------

  //@Return grid of the plaintext after decryption
  static Grid inverseSingleTransposition(Ciphertext encryptedText, Key key) {
    int keyLen = key.getKeyLen();
    int cipherTextLen = encryptedText.length();
    //First put the encrypted text into a inversed grid (row and col are inversed)
    Grid inversedGrid = new Grid(KeyFun.getRowLen(keyLen, cipherTextLen), encryptedText.getText());

    //Create a grid to store the plaintext
    Grid plaintextGrid = new Grid(keyLen, encryptedText.getText());
    

    //For each row in the inversed grid, place the row in the plaintext grid according to the key
      //For example # key first read col 7, the placed the 1st row to col 7 in the plaintext grid
    for(int i = 0; i < inversedGrid.getRowCount(); i++)
    {
      int colToPlace = key.indexOf(i);
      plaintextGrid.replaceCol(inversedGrid.getRow(i), colToPlace);
    }
    
    return plaintextGrid;
  }

  //Remove the consecutive fillchar at the end of the plaintext
  static String rStripFillChar(String plaintext, Character fillchar)
  {
    for(int i = plaintext.length() - 1; i >= 0; i--)
    {
      if(plaintext.charAt(i) != fillchar)
      {
        return plaintext.substring(0, i + 1);
      }
    }

    return "";
  }
  //--------------------------------------------------------------------------------
  
}