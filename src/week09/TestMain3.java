package week09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestMain3 {
    static void fileMerge(String fileName1, String fileName2, String outFile) {
        Scanner file1 = null;
        Scanner file2 = null;
        PrintWriter outfile = null;
        try {
            file1 = new Scanner(new File(fileName1));
            file2 = new Scanner(new File(fileName2));
            outfile = new PrintWriter(outFile);
            fileWrite(file1, outfile);
            fileWrite(file2, outfile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if(file1 != null) file1.close();
            if(file2 != null) file2.close();
            if(outfile != null) outfile.close();
        }
    }

    static void fileMerge2(String fileName1, String fileName2, String outFile) {
        try (Scanner file1 = new Scanner(new File(fileName1)); Scanner file2 = new Scanner(new File(fileName2)); PrintWriter outfile = new PrintWriter(outFile)) {
            fileWrite(file1, outfile);
            fileWrite(file2, outfile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fileWrite(Scanner file, PrintWriter outfile) {
        while(file.hasNextLine()) {
            outfile.println(file.nextLine());
        }
    }

    static void main() {
//        fileMerge("res/words1.txt", "res/words2.txt", "res/words.txt");
        fileMerge2("res/words1.txt", "res/words2.txt", "res/words.txt");
    }
}
