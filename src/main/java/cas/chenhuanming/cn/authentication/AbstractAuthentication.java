package cas.chenhuanming.cn.authentication;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by Administrator on 2017-05-12.
 */
public abstract class AbstractAuthentication implements Authentication{

    private Collection<GrantedAuthority> authorities;
    protected Object details;
    protected boolean authenticated;

    protected AbstractAuthentication(Collection<GrantedAuthority> authorities) {
        if(authorities==null)
            this.authorities = Collections.emptyList();
        else
            this.authorities = Collections.unmodifiableCollection(authorities);
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    @Override
    public Object getDetails() {
        return details;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public Object getAuthorities() {
        return authorities;
    }
}
