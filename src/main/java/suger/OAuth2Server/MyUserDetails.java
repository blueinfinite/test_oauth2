package suger.OAuth2Server;

import org.springframework.security.core.userdetails.User;

import java.util.Collections;

import static java.util.Collections.EMPTY_SET;

public class MyUserDetails extends User {

    private UserModel user;

    public MyUserDetails(UserModel user) {
        super(user.getUsername(),user.getPassword(),true,true,true,true,EMPTY_SET);
        this.user = user;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user=user;
    }
}
