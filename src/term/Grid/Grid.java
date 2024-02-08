package term.Grid;
import java.util.ArrayList;

//Damn Copilot write the whole fking class for me

public class Grid {
  private ArrayList<StringBuilder> grid;
  private int rowCount;
  private int colCount;
  private static final char fillerChar = '*';

  public Grid(int col, String text) {
    this(col, text, fillerChar);
  }
  public Grid(int col, String text, char fillerChar) {
    this.grid = new ArrayList<>();
    this.rowCount = text.length() / col;
    this.colCount = col;

    for (int i = 0; i < rowCount; i++) {
      StringBuilder row = new StringBuilder(text.substring(i * col, (i + 1) * col));
      grid.add(row);
    }
  }

  public Grid insertRow(String row, int pos) {
    grid.add(pos, new StringBuilder(row));
    rowCount++;
    return this;
  }

  public Grid insertCol(String col, int pos) {
    for (int i = 0; i < rowCount; i++) {
      grid.get(i).insert(pos, col.charAt(i));
    }
    colCount++;
    return this;
  }

  public String getRow(int pos) {
    return grid.get(pos).toString();
  }

  public String getCol(int pos) {
    StringBuilder col = new StringBuilder();
    for (int i = 0; i < rowCount; i++) {
      col.append(grid.get(i).charAt(pos));
    }
    return col.toString();
  }

  public boolean equals(Grid grid) {
    if (this.rowCount != grid.rowCount || this.colCount != grid.colCount) {
      return false;
    }
    for (int i = 0; i < rowCount; i++) {
      if (!this.grid.get(i).toString().equals(grid.grid.get(i).toString())) {
        return false;
      }
    }
    return true;
  }
}
