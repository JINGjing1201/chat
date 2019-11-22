package chat.client.model;

import chat.client.data.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Thread extends java.lang.Thread {
    private Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public Thread(Socket socket){
        this.socket=socket;
    }
    public void run(){
        //不停读取客户端发来的消息
        while (true){
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message= (Message) objectInputStream.readObject();
                System.out.println("读到从服务器发来的消息"+message.getSender());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
