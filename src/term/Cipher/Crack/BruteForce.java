package term.Cipher.Crack;

import term.Permutations.Permutations;
import term.Text.*;
import term.Key.*;

//A super class that is intended to be extended by all brute force cracking classes
public class BruteForce implements Crack{
  Plaintext plaintext;
  int attempts;
  String lastResult;
  
  BruteForce(Plaintext tagetedText){
    this.plaintext = tagetedText;
    this.attempts = 0;
    this.lastResult = "";
  }

  //It returns the plaintext...
  public String crack(Ciphertext ciphertext){
    attempts = 0;
    lastResult = "";
    
    Integer indexPointer = 0;
    int[] possibleKeyLen = getPossibleKeyLen(ciphertext);
    Permutations perm = null;
    
    while(hasNextKey(possibleKeyLen, indexPointer, perm)){ 
      // create a key variable 
      // assigne the permutation to the key
      
      // create a result variable
      // assign the result of the decryption to the result variable
      // compare the result to plaintext (original text)

      //if the result is the same as the plaintext
        //return the result
      
      //else
      //increment the attempts
    }

    return null;
  }

  public int getAttempts(){
    return attempts;
  }

  public String getLastResult(){
    return lastResult;
  }

  //return an array of possible key length in ascending order, and -1 at the end
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

  //return true if there is a next key
  //automatically update the indexPointer and permutation object
  protected boolean hasNextKey(int [] possibleKeyLen, Integer indexPointer, Permutations perm){
    if(perm != null && perm.hasNext())
    {
      return true;
    }
    else
    {
      if(possibleKeyLen[indexPointer] != -1)
      {
        perm = new Permutations(possibleKeyLen[indexPointer]);
        indexPointer++;
        return true;
      }
      else
      {
        return false;
      }
    }
  }

  protected boolean plaintextSameAs(Plaintext result){
    return this.plaintext.equals(result);
  }

  protected void setLastResult(String result){
    this.lastResult = result;
  }
}
