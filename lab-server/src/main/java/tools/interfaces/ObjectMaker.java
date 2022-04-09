package tools.interfaces;

import tools.exceptions.NotCorrectArgumentException;

public interface ObjectMaker<T> {
    T makeObject(String[] s) throws NotCorrectArgumentException;
}
