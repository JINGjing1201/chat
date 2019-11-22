package chat.client.model;

import java.util.HashMap;

public class ThreadManager {
    //String 是loginname
    private static HashMap hashMap=new HashMap<String,Thread>();
    public static void clientadd(String loginname,Thread thread){
        hashMap.put(loginname,thread);
    }
    public static Thread getclient(String loginname){
        return (Thread) hashMap.get(loginname);
    }


}
