package term;

import java.time.Clock;

//Wrapper class for java Random for static access
public class Random {
  static java.util.Random random = new java.util.Random(Clock.systemUTC().millis());
  
  static public int nextInt() {
    return random.nextInt();
  }
  
  static public int nextInt(int bound) {
    return random.nextInt(bound);
  }

  static public char nextLetter(){
    return (char) (random.nextInt(26) + 'a');
  }
}
