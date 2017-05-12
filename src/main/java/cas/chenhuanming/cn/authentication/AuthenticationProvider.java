package cas.chenhuanming.cn.authentication;

import cas.chenhuanming.cn.authentication.exception.AuthenticationException;

/**
 * Created by Administrator on 2017-05-12.
 */
public interface AuthenticationProvider {
    Authentication authenticate(Authentication authentication) throws AuthenticationException;

    boolean supports(Class<?> authentication);
}
