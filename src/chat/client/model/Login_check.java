package chat.client.model;

import chat.client.data.User;

public class Login_check {
    public boolean verify(User user){
        Service service=new Service();
        return service.send(user);
    }
}
