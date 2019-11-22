package chat.server.model;

import chat.client.data.Message;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.Executors;

/*
单开一个线程与客户端保持通讯
 */
public class Thread extends java.lang.Thread {



    private Socket socket;
    public Thread(Socket socket){
        this.socket=socket;

}

    public void run(){
        while (true){
            /*
                        try {

                //读取客户端消息
                ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
                //通过message传输
                Message message=(Message) objectInputStream.readObject();
                System.out.println(message.getSender()+" 给 "+message.getAccepter()+" 发送了一条消息： "+message.getContent()+" 时间： "+message.getSendtime());
                //转发
                Thread thread = ThreadManager.getthread(message.getAccepter());
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(thread.socket.getOutputStream());
                objectOutputStream.writeObject(message);

            } catch (Exception e) {
                e.printStackTrace();
            }
             */
            System.out.println(socket);
            //this.start();
        }
    }


}
