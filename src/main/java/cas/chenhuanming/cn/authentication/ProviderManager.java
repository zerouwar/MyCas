package cas.chenhuanming.cn.authentication;

import cas.chenhuanming.cn.authentication.exception.AuthenticationException;
import cas.chenhuanming.cn.authentication.exception.BadCredentialsException;
import cas.chenhuanming.cn.authentication.exception.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017-05-12.
 */
public class ProviderManager implements AuthenticationManager {
    private final List<AuthenticationProvider> providers;

    public ProviderManager(List<AuthenticationProvider> providers) {
        this.providers = providers;
    }

    public ProviderManager(AuthenticationProvider... providers) {
        this.providers = Arrays.asList(providers);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        AuthenticationException lastException = null;
        for (AuthenticationProvider provider:providers) {
            if(!provider.supports(authentication.getClass()))
                continue;
            try {
                Authentication auth = provider.authenticate(authentication);
                if(auth==null)
                    continue;;
                if(auth.isAuthenticated())
                    return auth;
            }catch (UsernameNotFoundException u){
                continue;
            }catch (BadCredentialsException b){
                lastException = b;
            }
        }
        throw lastException;
    }
}
