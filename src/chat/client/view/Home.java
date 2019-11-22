package chat.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Home extends JFrame implements ActionListener, MouseListener {
    private CardLayout c;

    /*
    第一张列表 好友
     */
    //j1是好友列表，j2是好友列表内容,j3是附近的人和我的空间
    private JLabel f_jl1;
    private JPanel f_jpanel,f_j1,f_j2,f_j3;
    private JButton f_jb1,f_jb2,f_jb3;
    private JScrollPane f_js;
    /*
    第二张列表 附近的人
    */
    private JLabel n_jl1;
    private JPanel n_jpanel,n_j1,n_j2,n_j3;
    private JButton n_jb1,n_jb2,n_jb3;
    private JScrollPane n_js;
    private String username;
    /*
    第三张列表 我的空间
    */
    private JLabel c_jl1;
    private JPanel c_jpanel,c_j1,c_j2;
    private JButton c_jb1,c_jb2,c_jb3;
    private JScrollPane c_js;
    public Home(String username){
        friend();
        nerby();
        center();
        c=new CardLayout();
        this.setLayout(c);
        this.add(f_jpanel,"1");
        this.add(n_jpanel,"2");
        this.add(c_jpanel,"3");
        showing(username);
    }
    public void friend(){
        f_jpanel=new JPanel(new BorderLayout());
        f_j1=new JPanel(new GridLayout(2,1));
        f_jl1=new JLabel(new ImageIcon("D:\\idea\\idea-workspace\\jave_original1\\src\\chat\\src\\4.png"));
        f_jb1=new JButton("我的好友");
        f_j1.add(f_jl1);
        f_j1.add(f_jb1);
        f_j2=new JPanel(new GridLayout(10,1,4,4));
        JLabel jl[]=new JLabel[10];
        for (int i = 0; i < jl.length; i++) {
            jl[i]=new JLabel(i+1+"pp",new ImageIcon("D:\\idea\\idea-workspace\\jave_original1\\src\\chat\\src\\3_3.png"),JLabel.LEFT);
            jl[i].addMouseListener(this);
            f_j2.add(jl[i]);
        }
        f_js=new JScrollPane(f_j2);
        f_j3=new JPanel(new GridLayout(2,1));
        f_jb2=new JButton("附近的人");
        f_jb2.addActionListener(this);
        f_jb3=new JButton("我的空间");
        f_jb3.addActionListener(this);
        f_j3.add(f_jb2);
        f_j3.add(f_jb3);
        f_jpanel.add(f_j1,"North");
        f_jpanel.add(f_js,"Center");
        f_jpanel.add(f_j3,"South");
    }
    public void nerby(){
        n_jpanel=new JPanel(new BorderLayout());
        n_j1=new JPanel(new GridLayout(3,1));
        n_jl1=new JLabel(new ImageIcon("D:\\idea\\idea-workspace\\jave_original1\\src\\chat\\src\\4.png"));
        n_jb1=new JButton("我的好友");
        n_jb1.addActionListener(this);
        n_jb2=new JButton("附近的人");
        n_j1.add(n_jl1);
        n_j1.add(n_jb1);
        n_j1.add(n_jb2);
        n_j2=new JPanel(new GridLayout(10,1,4,4));
        JLabel jl[]=new JLabel[10];
        for (int i = 0; i < jl.length; i++) {
            jl[i]=new JLabel(i+1+"pp",new ImageIcon("D:\\idea\\idea-workspace\\jave_original1\\src\\chat\\src\\4_1.png"),JLabel.LEFT);
           jl[i].addMouseListener(this);
            n_j2.add(jl[i]);
        }
        n_js=new JScrollPane(n_j2);
        n_j3=new JPanel(new GridLayout(1,1));
        n_jb3=new JButton("我的空间");
        n_jb3.addActionListener(this);
        n_j3.add(n_jb3);
        n_jpanel.add(n_j1,"North");
        n_jpanel.add(n_js,"Center");
        n_jpanel.add(n_j3,"South");

    }
    public void center(){
        c_jpanel=new JPanel(new BorderLayout());
        c_j1=new JPanel(new GridLayout(4,1));
        c_jl1=new JLabel(new ImageIcon("D:\\idea\\idea-workspace\\jave_original1\\src\\chat\\src\\4.png"));
        c_jb1=new JButton("我的好友");
        c_jb1.addActionListener(this);
        c_jb2=new JButton("附近的人");
        c_jb2.addActionListener(this);
        c_jb3=new JButton("我的空间");
        c_j1.add(c_jl1);
        c_j1.add(c_jb1);
        c_j1.add(c_jb2);
        c_j1.add(c_jb3);
        c_j2=new JPanel(new GridLayout(2,1,4,4));
        JLabel jl[]=new JLabel[2];
        for (int i = 0; i < jl.length; i++) {
            jl[i]=new JLabel(new ImageIcon("D:\\idea\\idea-workspace\\jave_original1\\src\\chat\\src\\5_4.png"));
            c_j2.add(jl[i]);
        }
        c_js=new JScrollPane(c_j2);
        c_jpanel.add(c_j1,"North");
        c_jpanel.add(c_js,"Center");
    }
    public void showing(String username){
        this.setTitle(username);
        this.username=username;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(100,100);
        this.setSize(250,600);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        Home t=new Home("bob");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==f_jb2){
            c.show(this.getContentPane(),"2");
        }
        else if(e.getSource()==f_jb3){
            c.show(this.getContentPane(),"3");
        }

        else if (e.getSource()==c_jb1) {
            c.show(this.getContentPane(),"1");
        }
        else if (e.getSource()==c_jb2) {
            c.show(this.getContentPane(),"2");
        }
        else if (e.getSource()==n_jb1) {
            c.show(this.getContentPane(),"1");
        }
        else if (e.getSource()==n_jb3) {
            c.show(this.getContentPane(),"3");
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==1){
            String chatname=((JLabel)e.getSource()).getText();
            System.out.println(" 会话接收者 "+chatname);
            System.out.println(" 会话发起者 "+username);
            Chat c=new Chat(username,chatname);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel j=(JLabel) e.getSource();
        j.setForeground(Color.pink);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel j=(JLabel) e.getSource();
        j.setForeground(Color.BLACK);
    }
}
