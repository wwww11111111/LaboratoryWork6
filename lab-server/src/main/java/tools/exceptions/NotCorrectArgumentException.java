package tools.exceptions;

public class NotCorrectArgumentException extends Exception{

    private int numberOfAnArgument;

    public NotCorrectArgumentException(int numberOfAnArgument) {
        this.numberOfAnArgument = numberOfAnArgument;
    }

    public void message (int i, int j) {
        System.out.println("Ошибка в строке " + i + " в аргументе " + j + ".");
    }

    public int getNumberOfAnArgument() {
        return numberOfAnArgument;
    }
}
