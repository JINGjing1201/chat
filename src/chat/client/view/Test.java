package chat.client.view;

import javax.xml.crypto.Data;
import java.net.Socket;
import java.util.Date;

public class Test {
    //a作为本地变量，经过函数改造t2,返回改造后的值
    public static Socket socket1;
    String a;
    public void t1(String a){
        this.a=a;
    }
    public void t2(){
        a="kelly";
    }
    public static void main(String[] args) {
        Test t=new Test();
        t.t2();
        System.out.println(t.a);
        t.t1("woody");
        System.out.println(t.a);
        System.out.println(new Date());
    }
}
