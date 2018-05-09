package suger.OAuth2Server;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import suger.TestFun;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;

@Primary
@Service("userDetailsService")
public class UserServiceImpl implements UserService {
    private final static Set<UserModel> users = new HashSet<>();

    static {
        users.add(new UserModel(1, "test-user1", "123451"));
        users.add(new UserModel(2, "test-user2", "123452"));
        users.add(new UserModel(3, "test-user3", "123453"));
        users.add(new UserModel(4, "test-user4", "123454"));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserModel> user=users.stream().filter(u->u.getUsername().equals(s)).findFirst();
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("找不到用户");
        } else {
            return UserDetailConverter.convert(user.get());
        }
    }

    private static class UserDetailConverter {
        static UserDetails convert(UserModel userModel) {
            return new MyUserDetails(userModel);
        }
    }




    public static void main(String[] args){

        Predicate<Integer> boolValue = x -> x > 5;
        TestFun<Integer> boolValue2 = x -> x > 6;

        Consumer<Integer> c1 = x -> x++;
        c1.accept(2);


        //-----------------
        UserModel user = new UserModel(1,"john@gmail.com", "1234");
        Optional<UserModel> opt = Optional.ofNullable(user);

        Optional.ofNullable(user);

        opt.isPresent();
        String email = Optional.ofNullable(user)
                .map(u -> u.getUsername()).orElse("default@gmail.com");

        Optional.ofNullable(user)
                .map(u -> u.getUsername()).orElse("default@gmail.com");
        user=null;
        Optional.ofNullable(user)
                .map(u -> u.getUsername()).orElse("default@gmail.com");

        Optional.ofNullable(user)
                .map(u -> u.getUsername()).orElse("default@gmail.com");

        String a;
    }
}
