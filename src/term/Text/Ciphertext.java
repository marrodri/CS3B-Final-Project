package term.Text;

import term.Grid.Grid;

public final class Ciphertext extends Text {

  public Ciphertext(String text) {
    super(text);
  }

  //Get the text in a grid format
  public Grid getGridText(int col_length) {
    return new Grid(col_length, super.getText(), Grid.fillChar);
  }

  //Get the text in a grid format with padding character specified
  public Grid getGridText(int col_length, Character paddingChar) {
    return new Grid(col_length, super.getText(), paddingChar);
  }
}