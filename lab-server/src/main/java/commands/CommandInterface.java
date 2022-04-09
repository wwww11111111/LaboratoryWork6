package commands;

import smyts.lab6.common.util.Response;

public interface CommandInterface {
    Response execute();
    String getDescription();
}
