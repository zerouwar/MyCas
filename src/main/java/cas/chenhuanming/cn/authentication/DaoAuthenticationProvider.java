package cas.chenhuanming.cn.authentication;

import cas.chenhuanming.cn.authentication.exception.AuthenticationException;

/**
 * Created by Administrator on 2017-05-12.
 */
public class DaoAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        if (username.equals("admin")&&password.equals("admin"))
            return new UsernamePasswordToken(username,password);
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
