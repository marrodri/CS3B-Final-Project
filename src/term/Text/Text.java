package term.Text;

public class Text {
  protected String text;

  public Text(String text){
    // Bro the copilot is reading my mind
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public int getTextLength() {
    return text.length();
  }

  @Override
  public String toString() {
    return text;
  }
}
