package suger.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import suger.OAuth2Server.MyUserDetails;
import suger.OAuth2Server.UserModel;

@Slf4j
//@RestController
public class User2Controller {


    public User2Controller(@Qualifier("tokenStore") TokenStore tokenStore) {
        log.info("============ User2Controller");
        this.tokenStore=tokenStore;
    }


    private TokenStore tokenStore;

    @PostMapping("/bar")
    public String bar(@RequestHeader("Authorization") String auth) {
        MyUserDetails userDetails = (MyUserDetails) tokenStore.readAuthentication(auth.split(" ")[1]).getPrincipal();
        UserModel user=userDetails.getUser();
        return user.getUsername() + " : "+ user.getPassword();
    }
}
