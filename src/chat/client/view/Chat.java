package chat.client.view;

import chat.client.data.Message;
import chat.client.model.Service;
import chat.client.model.Thread;
import chat.client.model.ThreadManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
//随时读取。是一个线程
public class Chat extends JFrame implements ActionListener {
    private JTextField jTextField;
    private JTextArea textArea;
    private JPanel jPanel;
    private JButton jButton;
    private String sender,accepter;
    public Chat(String username ,String chatname){
        middle();
        bottom();
        this.setTitle(username+" : 你正在和 "+chatname+" 聊天...");
        this.sender=username;
        this.accepter=chatname;
        this.setIconImage(new ImageIcon("D:\\idea\\idea-workspace\\jave_original1\\src\\chat\\src\\5.png").getImage());
        showing();
    }
    public void middle(){
        textArea=new JTextArea();
        this.add(textArea,"Center");
    }
    public void bottom(){
        jPanel=new JPanel();
        jTextField=new JTextField(35);
        jButton=new JButton("发送");
        jButton.addActionListener(this);
        jPanel.add(jTextField);
        jPanel.add(jButton);
        this.add(jPanel,"South");
    }
    public void showing(){
        this.setLocation(350,200);
        this.setSize(450,250);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Chat c=new Chat("woody","bob");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jButton){
            Message m=new Message();
            m.setSender(sender);
            m.setAccepter(accepter);
            m.setContent(jTextField.getText().trim());
            Date date=new Date();
            m.setSendtime(date.toString());
            try {
                //把消息发送给服务器
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(ThreadManager.getclient(sender).getSocket().getOutputStream());
                objectOutputStream.writeObject(m);
                jTextField.setText("");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

//    @Override
//    public void run() {
//        while (true){
//            try {
//                ObjectInputStream objectInputStream=new ObjectInputStream(Service.socket1.getInputStream());
//                Message message= (Message) objectInputStream.readObject();
//                String information=message.getContent();
//                this.textArea.append(information);
//                System.out.println(message.getContent());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
