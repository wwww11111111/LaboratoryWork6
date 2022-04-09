package tools;

import smyts.lab6.common.util.Request;
import smyts.lab6.common.util.Response;
import smyts.lab6.common.util.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ConnectionWorker {

    public static Request receiveCommandNameAndArguments(Socket socket) throws IOException,
            ClassNotFoundException {
        byte[] bytes = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        inputStream.read(bytes);

        Request request = Serializer.deSerializeRequest(bytes);
        return request;

    }

    public static Request askForAnObjectResponse(Socket socket) throws IOException,
            ClassNotFoundException {
        Response response = new Response();
        response.setObjectNeeded(true);
        response.setMessage("введите чувака");
        socket.getOutputStream().write(Serializer.serializeResponse(response).array());
        //response.setMessage("");
        return receiveCommandNameAndArguments(socket);
    }

    public static void sendResponse(Socket socket, Response response) throws IOException,
            ClassNotFoundException {
        socket.getOutputStream().write(Serializer.serializeResponse(response).array());
    }

}
