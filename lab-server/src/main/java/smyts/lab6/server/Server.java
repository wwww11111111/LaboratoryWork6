package smyts.lab6.server;
import tools.*;

import java.io.IOException;

public final class Server {
    private Server() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Application.start(args);

    }
}

