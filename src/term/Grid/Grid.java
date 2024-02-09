package term.Grid;
import java.util.ArrayList;

//Damn Copilot write the whole fking class for me

public class Grid implements Cloneable{
  private ArrayList<StringBuilder> grid;
  private int rowCount;
  private int colCount;
  public static final char fillChar = '*';

  //Sample usage
  public static void main(String[] args) {
    Grid grid = new Grid(4, "Hello, World!");
    System.out.println(grid);
    
    Grid grid2 = (Grid) grid.clone();

    System.out.println(grid.equals(grid2));
    System.out.println(grid2 == grid);

    grid = grid.insertRow("WE'R", 0);
    grid = grid.insertRow("#1MA", 1);
    grid = grid.insertRow("----", 2);
    grid = grid.insertCol("EN-ooo*", 4);

    System.out.println(grid);

  }

  public Grid(int col_len, String text) {
    this(col_len, text, fillChar);
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

  //return a new grid with the row inserted at the specified position
  public Grid insertRow(String rowStr, int pos) {
    if(rowStr.length() != colCount) {
      throw new IllegalArgumentException("Row length must be equal to the number of columns");
    }
    
    if(pos < 0 || pos > rowCount) {
      throw new IllegalArgumentException("Invalid row position");
    }

    Grid ret = (Grid) this.clone();
    ret.grid.add(pos, new StringBuilder(rowStr));
    ret.rowCount++;
    return ret;
  }

  //return a new grid with the column inserted at the specified position
  public Grid insertCol(String colStr, int pos) {
    if(colStr.length() != rowCount) {
      throw new IllegalArgumentException("Column length must be equal to the number of rows");
    }
    
    if (pos < 0 || pos > colCount) {
      throw new IllegalArgumentException("Invalid column position");
    }

    Grid ret = (Grid) this.clone();
    for (int i = 0; i < rowCount; i++) {
      ret.grid.get(i).insert(pos, colStr.charAt(i));
    }
    ret.colCount++;
    return ret;
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

  @Override
  public boolean equals(Object grid) {
    if (grid instanceof Grid == false || grid == null) {
      return false;
    }

    if (this.rowCount != ((Grid)grid).rowCount || this.colCount != ((Grid)grid).colCount) {
      return false;
    }
    
    for (int i = 0; i < rowCount; i++) {
      if (!this.grid.get(i).toString().equals(((Grid)grid).grid.get(i).toString())) {
        return false;
      }
    }
    
    return true;
  }

  @Override
  public Object clone(){
    try
    {
      return super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw null;
    }
  }
  
  @Override
  public String toString() {
    StringBuilder gridStr = new StringBuilder("\n");
    for (int i = 0; i < rowCount; i++) {
      gridStr.append(grid.get(i).toString() + "\n");
    }
    return gridStr.toString();
  }
}
