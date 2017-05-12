package cas.chenhuanming.cn.authentication;

/**
 * Created by Administrator on 2017-05-12.
 */
public class SimpleAuthority implements GrantedAuthority {
    private String authority;

    public SimpleAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
