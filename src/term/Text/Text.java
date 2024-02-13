package term.Text;

public class Text{
  protected final String text;

  static public void main(String[] args) {
    Plaintext p1 = new Plaintext("Hello World");
    Plaintext p2 = new Plaintext("Hello World");
    Ciphertext c1 = new Ciphertext("Hello World");
    System.out.println("p1 equals c1? " + p1.equals(c1));
    System.out.println("p1 equals p2? " + p1.equals(p2));
  }

  public Text(String text){
    // Bro the copilot is reading my mind
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public int length() {
    return text.length();
  }

  @Override
  public String toString() {
    return text;
  }
  
  @Override
  public boolean equals(Object obj) {
    //Trivial check
    if (this == obj) { //same reference
      return true;
    }

    if (obj == null) { //null reference
      return false;
    }

    if (getClass() != obj.getClass()) { //different classes
      return false;
    }

    //Actual check
    Text other = (Text) obj;
    if (text == null) {
      if (other.text != null) {
        return false;
      }
    } 
    else if (!text.equals(other.text)) {
      return false;
    }

    return true;
  }
}
