package chat.client.view;

import chat.client.data.User;
import chat.client.model.Login_check;
import chat.client.model.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
客户端登陆界面
 */
public class Login extends JFrame implements MouseListener, ActionListener {
    /*
    分三层
     */
    //上面组件
    private JLabel t_jLabel;
    //中间组件
    //选项卡管理窗口
    private JTabbedPane c_manager;
    private JPanel c_jp1,c_jp2;
    private JLabel c_jp1_jb1,c_jp1_jb2;
    private JTextField c_jp1_jt1;
    private JPasswordField c_jp1_jps1;
    private JCheckBox c_jp1_jc1,c_jp1_jc2;
    //左边
    private JLabel l_jlabel;
    //下方组件
    private JPanel b_jPanel;
    private JButton b_button1,b_button2;
    private JLabel b_jlabel1,b_jlabel2,b_jlabel3;
    public Login(){
        top();
        middle();
        bottom();
        left();
        showing();

    }
    /*
    上
     */
    public void top(){
        t_jLabel=new JLabel(new ImageIcon("D:\\idea\\idea-workspace\\jave_original1\\src\\chat\\src\\1.png"));
        this.add(t_jLabel,"North");
    }
    /*
    中
     */
    public void middle(){
        c_jp1=new JPanel(new GridLayout(4,2));
        c_jp1_jb1=new JLabel("账号");
        c_jp1_jb2=new JLabel("密码");
        c_jp1_jt1=new JTextField();
        c_jp1_jps1=new JPasswordField();
        c_jp1_jc1=new JCheckBox("自动登陆");
        c_jp1_jc2=new JCheckBox("忘记密码");
        c_jp1_jc2.setForeground(Color.pink);
        c_jp1.add(c_jp1_jt1);
        c_jp1.add(c_jp1_jb1);
        c_jp1.add(c_jp1_jps1);
        c_jp1.add(c_jp1_jb2);
        c_jp1.add(c_jp1_jc1);
        c_jp1.add(c_jp1_jc2);
        c_jp2=new JPanel(new GridLayout(4,2));
        c_manager=new JTabbedPane();
        c_manager.add("账号登陆",c_jp1);
        c_manager.add("手机登陆",c_jp2);
        this.add(c_manager,"Center");
    }
    /*
    左
    */
    public void left(){
        l_jlabel=new JLabel(new ImageIcon("D:\\idea\\idea-workspace\\jave_original1\\src\\chat\\src\\2_1.png"));
        this.add(l_jlabel,"West");
    }
    /*
    下
     */
    public void bottom(){
        b_jPanel=new JPanel(new GridLayout(1,5));
        b_button1=new JButton("登陆");
        b_button1.addActionListener(this);
        b_button2=new JButton("注册");
        b_jlabel1=new JLabel(" ");
        b_jlabel2=new JLabel(" ");
        b_jlabel3=new JLabel(" ");
        b_jPanel.add(b_jlabel1);
        b_jPanel.add(b_button1);
        b_jPanel.add(b_button2);
        b_jPanel.add(b_jlabel2);
        b_jPanel.add(b_jlabel3);
        this.add(b_jPanel,"South");
    }
    public void showing(){
        this.setSize(440,350);
        this.setLocation(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b_button1){
            User user=new User();
            String username=c_jp1_jt1.getText().trim();
            String password=new String(c_jp1_jps1.getPassword());
            user.setUsername(username);
            user.setPassword(password);
            Login_check login_check=new Login_check();
            if(login_check.verify(user)){
                System.out.println("客户端验证成功");
                new Home(user.getUsername());
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(this,"用户名或密码错误");
            }
        }
    }
}
