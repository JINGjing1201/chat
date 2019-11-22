package chat.client.model;

import chat.client.data.Message;
import chat.client.data.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Service {
    private Socket socket;
    public boolean send(Object object){
            boolean b=false;
        try {
            System.out.println("9988端口: 客户端输出...");
            socket=new Socket("127.0.0.1",9988);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(object);
            ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
            Message message=(Message) objectInputStream.readObject();
            if(message.getMessagetype().equals("1")){
                System.out.println("客户端接收到验证信息---成功！");
                //创建一个该qq号与服务器保持通讯的线程
                Thread thread=new Thread(socket);
                thread.start();
                ThreadManager.clientadd(((User) object).getUsername(),thread);
                b=true;

            }
            else {
                System.out.println("客户端接收到验证信息---失败！");
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {

        }
        return b;
    }



}
