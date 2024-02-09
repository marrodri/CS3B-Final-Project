package term.Text;

public class Text {
  protected final String text;

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
}
