package com.example.project.config;

import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.sql.DataSource;

@Configuration
public class ShiroConfig {

    // تعریف Realm برای احراز هویت و مجوزدهی
    @Bean
    public Realm realm(DataSource dataSource) {
        // تنظیم الگوریتم هش و تعداد تکرارها
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("SHA-256");
        credentialsMatcher.setHashIterations(1024);

        // تنظیم JdbcRealm برای اتصال به دیتابیس
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setAuthenticationQuery("SELECT password FROM users WHERE username = ?");
        jdbcRealm.setUserRolesQuery("SELECT role_name FROM user_roles WHERE username = ?");
        jdbcRealm.setPermissionsQuery("SELECT permission FROM roles_permissions WHERE role_name = ?");

        // تنظیم matcher برای مقایسه رمز عبور
        jdbcRealm.setCredentialsMatcher(credentialsMatcher);
        jdbcRealm.setPermissionsLookupEnabled(true);

        return jdbcRealm;
    }

    // تعریف فیلترهای Shiro برای مسیرهای مختلف
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

        // مسیرهای آزاد
        chainDefinition.addPathDefinition("/login", "anon"); // مسیر ورود آزاد
        chainDefinition.addPathDefinition("/logout", "logout"); // مسیر خروج

        // مسیرهای محافظت شده
        chainDefinition.addPathDefinition("/admin/**", "authc, roles[admin]"); // مسیرهای ادمین
        chainDefinition.addPathDefinition("/user/**", "authc, roles[user]"); // مسیرهای کاربر

        // سایر مسیرها باید احراز هویت شوند و به صفحه ورود هدایت شوند
        chainDefinition.addPathDefinition("/**", "authc"); // سایر مسیرها باید احراز هویت شوند و به صفحه ورود هدایت شوند

        return chainDefinition;
    }
}
