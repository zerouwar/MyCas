package cas.chenhuanming.cn.authentication;

import java.util.Collection;

/**
 * Created by Administrator on 2017-05-12.
 */
public class UsernamePasswordToken extends AbstractAuthentication{
    private String username;
    private String password;

    public UsernamePasswordToken() {
        super(null);
    }

    public UsernamePasswordToken(String username, String password) {
        super(null);
        this.username = username;
        this.password = password;
        this.authenticated = true;
    }

    public UsernamePasswordToken(String username, String password,Collection<GrantedAuthority> authorities) {
        super(authorities);
        this.username = username;
        this.password = password;
        this.authenticated = true;
    }

    public UsernamePasswordToken(String username, String password,Object details) {
        this(username,password);
        this.details = details;
    }


    public void authenticated(){
        this.authenticated = true;
    }

    @Override
    public String getPrincipal() {
        return username;
    }

    @Override
    public String getCredentials() {
        return password;
    }

}
