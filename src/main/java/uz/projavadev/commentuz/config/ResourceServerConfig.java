package uz.projavadev.commentuz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("api");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/v1/category/getAll","/api/v1/subCategory/*","/api/v1/post/*","/api/v1/tag/search").permitAll()
                .antMatchers(HttpMethod.POST,"/api/v1/user/register","/api/v1/user/login").permitAll()
                .antMatchers("/api/v1/tag/**").hasAnyAuthority("DEVELOPER","ADMINISTRATOR")
                .antMatchers("/api/v1/category/**").hasAnyAuthority("DEVELOPER","ADMINISTRATOR")
                .antMatchers("/api/v1/user/create/admin").hasAuthority("DEVELOPER")
                .antMatchers("/api/v1/user/create/moder").hasAnyAuthority("DEVELOPER","ADMINISTRATOR")
                .anyRequest().authenticated();
    }
}
