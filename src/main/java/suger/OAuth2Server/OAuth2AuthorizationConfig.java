package suger.OAuth2Server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Slf4j
@Configuration
@EnableAuthorizationServer
@EnableResourceServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
    public OAuth2AuthorizationConfig() {
        log.info("============ OAuth2AuthorizationConfig");
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
        log.info("============ OAuth2AuthorizationConfig.configure");
        clients.inMemory()
                .withClient("test")
                .authorizedGrantTypes("password","refresh_token")
                .scopes("read","write")
                .secret("123456")
                .accessTokenValiditySeconds(10000)//token过期时间
                .refreshTokenValiditySeconds(10000);//refresh过期时间
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)  throws Exception{
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);//配置userService 这样每次认证的时候会去检验用户是否锁定，有效等

    }



}
