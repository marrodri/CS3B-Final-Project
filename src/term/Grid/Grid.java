package term.Grid;
import java.util.ArrayList;

//Damn Copilot write the whole fking class for me

public class Grid {
  private ArrayList<StringBuilder> grid;
  private int rowCount;
  private int colCount;
  private static final char fillerChar = '*';

  public static void main(String[] args) {
    Grid grid = new Grid(4, "Hello, World!");
    System.out.println(grid);
  }

  public Grid(int col_len, String text) {
    this(col_len, text, fillerChar);
  }

  public Grid(int col_len, String text, char fillerChar) {
    this.grid = new ArrayList<>();
    this.colCount = col_len;
    this.rowCount = Math.ceilDiv(text.length(), col_len);

    int remainder = col_len - text.length() % col_len;
    
    if (remainder != 0) {
      for (int i = 0; i < remainder; i++) {
        text += fillerChar;
      }
    }
    
    for (int i = 0; i < rowCount; i++) {
      StringBuilder row = new StringBuilder(text.substring(i * col_len, (i + 1) * col_len));
      grid.add(row);
    }

  }

  public Grid insertRow(String rowStr, int pos) {
    if(rowStr.length() != colCount) {
      throw new IllegalArgumentException("Row length must be equal to the number of columns");
    }
     
    grid.add(pos, new StringBuilder(rowStr));
    rowCount++;
    return this;
  }

  public Grid insertCol(String colStr, int pos) {
    if(colStr.length() != rowCount) {
      throw new IllegalArgumentException("Column length must be equal to the number of rows");
    }

    for (int i = 0; i < rowCount; i++) {
      grid.get(i).insert(pos, colStr.charAt(i));
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

  @Override
  public String toString() {
    StringBuilder gridStr = new StringBuilder();
    for (int i = 0; i < rowCount; i++) {
      gridStr.append(grid.get(i).toString());
      gridStr.append("\n");
    }
    return gridStr.toString();
  }
}
