package chat.server.model;

import java.util.HashMap;

public class ThreadManager {
    public static HashMap hashMap=new HashMap<String, Thread>();
    public static void addthread(String usename, Thread thread){
        hashMap.put(usename, thread);
    }
    public static Thread getthread(String usename){
        return (Thread) hashMap.get(usename);
    }
}
