package term.Cipher.Crack;

import term.Cipher.Decrypt.DecryptSingleTransposition;
import term.Key.NumericKey;
import term.Permutations.Permutations;
import term.Text.Ciphertext;
import term.Text.Plaintext;

public class KnownPlaintext extends BruteForce {
  Plaintext knownPlaintext;

  public KnownPlaintext(Plaintext knownPlaintext){
    super(knownPlaintext);
    this.knownPlaintext = knownPlaintext;
  }

  //It returns the key that was used to encrypt the known plaintext
  public String crack(Ciphertext ciphertext){
    // Implementation goes here
    //remeber to increment the attempts

    int[] keyLen = getPossibleKeyLen(ciphertext);
    Permutations perm = null;
    Integer indexPointer = 0;

    while(super.hasNextKey(keyLen, indexPointer, perm)){
      NumericKey key = new NumericKey(perm.next());

      String result = DecryptSingleTransposition.decrypt(ciphertext, key).getText();

      attempts++;
      if(result.equals(knownPlaintext.getText())){
        
        return key.getKey();
      }
    }
    return null;
  }

  @Override
  protected int[] getPossibleKeyLen(Ciphertext ciphertext){
    int cipherTextLen = ciphertext.length();
    int[] possibleKeyLen = new int[6 + 1]; // Key length is from 5 - 10 (total 6) + 1 (-1 the ending index)
    int index = 0;

    
    for(int i = 5; i <= 10; i++){
      if(cipherTextLen % i == 0){
        possibleKeyLen[index] = i;
        index++;
      }
    }

    possibleKeyLen[index] = -1;
    return possibleKeyLen;
  }
}
