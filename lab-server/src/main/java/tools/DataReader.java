package tools;

import tools.exceptions.NoSomeArgumentsException;

import java.io.*;
import java.util.Scanner;

/**
 * class for reading the information from the file and from terminal
 */

public class DataReader {
    //class responsible for parcing csv file by lines and checking its correctness
    private String path;
    private FileInputStream fis = null;
    private InputStreamReader isr = null;
    private Scanner scanner = new Scanner(System.in);
    private boolean isInteractive = false;
    private BufferedReader br = null;

    public DataReader(String path)  {
        this.path = path;

        try {
            fis = new FileInputStream(path);
            isr = new InputStreamReader(fis, "UTF-8");
            br = new BufferedReader(isr);
        } catch (FileNotFoundException |UnsupportedEncodingException e) {
            System.out.println("Ошибка! Проверьте правильность указанного пути до файла " +
                    "(он должен быть передан как аргумент командной строки).");
            System.exit(1);
        }

    }

    /**
     *
     * @return string from user
     */

    public String readline() {
        if (isInteractive) {
            return scanner.nextLine();
        }
        try {
            return br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean isCorrect(String line) throws NoSomeArgumentsException {

        String[] splittedString = line.split(",");

        if (splittedString.length != 14) {
            throw new NoSomeArgumentsException();
        }

        return true;

    }


    public String getPath() {
        return path;
    }

    public void setInteractive(boolean interactive) {
        isInteractive = interactive;
    }

    public void setPath(String path) throws FileNotFoundException, UnsupportedEncodingException {
        this.path = path;
        fis = new FileInputStream(path);
        isr = new InputStreamReader(fis, "UTF-8");
    }

    public Scanner getScanner() {
        return scanner;
    }
}