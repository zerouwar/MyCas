package cas.chenhuanming.cn.authentication.exception;

/**
 * Created by Administrator on 2017-05-12.
 */
public class UsernameNotFoundException extends AuthenticationException {
    public UsernameNotFoundException() {
        super(ExceptionCode.USERNAME_NOT_FOUND);
    }
}
