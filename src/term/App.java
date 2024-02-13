package term;

import java.io.File;
import java.util.Scanner;

public class App {
    //TODO: run app.


    public void runApp() {
        Scanner userInput = new Scanner(System.in);
        File file = new File("file.txt");
        Scanner fileInput;
        try {
            fileInput = new Scanner(file);
            System.out.println(fileInput.nextLine());
        } catch (Exception e) {
            System.out.println(e);
        }


        /**
         * the program will run and ask a question to the user.
         * 1st- Want to encrypt a plainText Input.
         * 2nd - Want to encrypt a plainText from a filePath.
         *
         * */
    }

    private void readInput() {
    }

    private void readPathFile() {
    }
}
