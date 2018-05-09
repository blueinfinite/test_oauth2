package suger;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

//@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        UserDetailsImpl ud = new UserDetailsImpl(1,"suger","123");
//        return ud;

        return new UserDetailsImpl(1L, "lisi", "password",
                Arrays.asList(
                        new SimpleGrantedAuthority("USER")
                        , new SimpleGrantedAuthority("ADMIN")
                )
                , true
                , new Date()
        );
    }
}
