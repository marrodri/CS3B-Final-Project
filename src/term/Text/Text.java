package term.Text;

import term.Grid.Grid;

public class Text {
  protected String text;

  public Text(String text){
    // Bro the copilot is reading my mind
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public Grid getGridText(int col_length) {
    // intentioanlly left blank
    //called it in Plaintext or Ciphertext class
    return null;
  }

  public Grid getGridText(int col_length, Character paddingChar) {
    // intentioanlly left blank
    //called it in Plaintext or Ciphertext class
    return null;
  }

  public int getTextLength() {
    return text.length();
  }

  @Override
  public String toString() {
    return text;
  }
}
