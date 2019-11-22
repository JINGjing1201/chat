package chat.server.view;

import chat.server.model.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private JPanel t_jpanel,t_j1,t_j2;
    private JButton jButton1,jButton2;
    private JLabel jLabel1,jLabel2;
    public Login(){
        top();
        showing();
    }
    public void top(){
        t_jpanel=new JPanel(new GridLayout(2,1));
        t_j1=new JPanel();
        jButton1=new JButton("连接");
        jButton1.addActionListener(this);
        jButton2=new JButton("断开");
        jButton2.addActionListener(this);
        t_j1.add(jButton1);
        t_j1.add(jButton2);
        t_j2=new JPanel(new GridLayout(2,1));
        jLabel1=new JLabel("在线用户",JLabel.CENTER);
        jLabel2=new JLabel("----------------------------------------------------",JLabel.CENTER);
        t_j2.add(jLabel1);
        t_j2.add(jLabel2);
        t_jpanel.add(t_j1);
        t_jpanel.add(t_j2);
        this.add(t_jpanel,"North");
    }
    public void showing(){
        this.setLocation(200,200);
        this.setSize(500,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Login l=new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jButton1){
            new Service();
        }
        if(e.getSource()==jButton2){
            this.dispose();
        }
    }
}
