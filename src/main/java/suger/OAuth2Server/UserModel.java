package suger.OAuth2Server;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserModel {
    private int id;
    private String username;
    private String password;
}
