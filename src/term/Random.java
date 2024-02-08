package term;

import java.time.Clock;

//Wrapper class for java Random for static access
public class Random {
  static java.util.Random random = new java.util.Random(Clock.systemUTC().millis());
  
  int nextInt() {
    return random.nextInt();
  }
  
  int nextInt(int bound) {
    return random.nextInt(bound);
  }

  char nextLetter(){
    return (char) (random.nextInt(26) + 'a');
  }
}
