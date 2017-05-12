package cas.chenhuanming.cn.authentication.exception;

/**
 * Created by Administrator on 2017-05-12.
 */
public class BadCredentialsException extends AuthenticationException {
    public BadCredentialsException() {
        super(ExceptionCode.BAD_CREDENTIALS);
    }
}
