package chat.server.model;

import chat.client.data.Message;
import chat.client.data.User;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Service  {

    public Service(){
        try {
            System.out.println("9988端口: 服务器端输出...");
            ServerSocket serverSocket=new ServerSocket(9988);
            while (true){
                Socket socket=serverSocket.accept();
                ObjectInputStream objectInputStream1=new ObjectInputStream(socket.getInputStream());
                User user=(User) objectInputStream1.readObject();
                System.out.println("服务器端接收到的信息———— 用户名："+user.getUsername()+" 密码： "+user.getPassword());
                Message m=new Message();
                ObjectOutputStream ob=new ObjectOutputStream(socket.getOutputStream());
                if(user.getPassword().equals("123")){
                    m.setMessagetype("1");
                    System.out.println("服务器端验证成功！");
                    ob.writeObject(m);

                    Thread thread=new Thread(socket);
//                    ThreadManager.addthread(m.getSender(),thread);
//                    System.out.println(thread+"------------");
                    thread.run();

                }
                else {
                    m.setMessagetype("2");
                    System.out.println("服务器端验证失败！");
                    ob.writeObject(m);
                    socket.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
