package term.Text;

public class Text {
  protected String text;
  protected String strippedText;

  public Text(String text){
    //Bro the copilot is reading my mind
    // this.text = text;
    // this.strippedText = text.replaceAll("[^a-zA-Z]", "").toUpperCase();
  }

  public String getText() {
    return text;
  }

  public String getStrippedText() {
    return strippedText;
  }

  public String[][] getGridText() {
    // Implement the logic to convert the text into a grid representation
    // and return the grid as a 2D array of strings
    return null;
  }

  public int getTextLength() {
    return text.length();
  }

  public int getStrippedTextLength() {
    return strippedText.length();
  }

  @Override
  public String toString() {
    return text;
  }
}
