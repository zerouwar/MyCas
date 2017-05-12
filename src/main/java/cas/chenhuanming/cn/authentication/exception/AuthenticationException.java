package cas.chenhuanming.cn.authentication.exception;

/**
 * Created by Administrator on 2017-05-12.
 */
public abstract class AuthenticationException extends RuntimeException {
    private ExceptionCode code;

    public AuthenticationException(ExceptionCode code) {
        this.code = code;
    }

    public ExceptionCode getCode() {
        return code;
    }
}
