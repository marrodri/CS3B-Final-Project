package helperFunctions;
import java.util.Scanner;
public class HelperFunctions {
        /**
     * console output methods
     */
    public static void print(String str) {
        System.out.print(str);
    }

    public static void printLine(String str) {
        System.out.println(str);
    }

    /**
     * user input getters methods
     * */

    public static int getUserInputInt(Scanner scanner) {
        return scanner.nextInt();
    }

    public static String getUserInputLine(Scanner scanner) {
        return scanner.nextLine();
    }

    public static double getUserInputDouble(Scanner scanner) {
        return scanner.nextDouble();
    }
}
