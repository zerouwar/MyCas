package cas.chenhuanming.cn.authentication;

/**
 * Created by Administrator on 2017-05-12.
 */
public interface Authentication {
    Object getPrincipal();

    Object getCredentials();

    Object getDetails();

    Object getAuthorities();

    boolean isAuthenticated();
}
