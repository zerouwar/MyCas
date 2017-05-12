package cas.chenhuanming.cn.authentication;

import java.util.Collection;

/**
 * Created by Administrator on 2017-05-12.
 */
public class PreAuthenticateAuthentication extends AbstractAuthentication{
    private final Object principal;
    private final Object credentials;

    public PreAuthenticateAuthentication(String principal, String credentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }
}
