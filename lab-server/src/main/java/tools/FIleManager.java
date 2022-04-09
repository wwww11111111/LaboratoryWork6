package tools;

import tools.exceptions.NoSomeArgumentsException;
import tools.exceptions.NotCorrectArgumentException;
import tools.interfaces.ObjectMaker;

import java.io.File;
import java.util.LinkedList;

/**
 * class appending the objects of the collection to the file
 * @param <T> type of the objects in file
 */

public class FIleManager<T> {

    //class responible for appending csvdata to the list

    private DataReader dataReader;
    private LinkedList<T> ll;
    private ObjectMaker<T> objectMaker;
    private File file;
    private int maxId = 0;

    public FIleManager(DataReader dataReader, LinkedList<T> ll, ObjectMaker<T> objectMaker) {
        this.dataReader = dataReader;
        this.ll = ll;
        this.objectMaker = objectMaker;
        this.file = new File(dataReader.getPath());
    }

    public void start() {

        int lineCounter = 1;
        String line = dataReader.readline();


        while (line != null) {
            String[] splittedString = line.split(",");

            try {
                if (dataReader.isCorrect(line)) {
                    if (Integer.parseInt(splittedString[0]) > maxId) {
                        maxId = Integer.parseInt(splittedString[0]);
                    }
                    try {
                        T obj = objectMaker.makeObject(splittedString);

                        ll.add(obj);
                    } catch (NotCorrectArgumentException e) {
                        e.message(lineCounter, e.getNumberOfAnArgument());
                    }
                }
            } catch (NoSomeArgumentsException e) {
                System.out.println("Ошибка! Отсутствуют некоторые аргументы в " + lineCounter + " строке.");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Id введен некорректно!");
            }

            line = dataReader.readline();
            lineCounter++;

        }
        System.out.println("Добавление элементов из файла произошло успешно!");
        dataReader.setInteractive(true);
    }

    public int getMaxId() {
        return maxId;
    }
}
