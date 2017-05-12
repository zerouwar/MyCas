package cas.chenhuanming.cn.authentication;

import cas.chenhuanming.cn.authentication.exception.AuthenticationException;

/**
 * Created by Administrator on 2017-05-12.
 */
public interface AuthenticationManager {
    Authentication authenticate(Authentication authentication) throws AuthenticationException;
}
