package term.Text;

import term.Grid.Grid;

public final class Plaintext extends Text {
  
  public Plaintext(String text) {
    super(text);
  }
  
  public Grid getGridText(int col_length) {
    return new Grid(col_length, super.getText(), Grid.fillChar);
  }

  public Grid getGridText(int col_length, Character paddingChar) {
    return new Grid(col_length, super.getText(), paddingChar);
  }
  
}
