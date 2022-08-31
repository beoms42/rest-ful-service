package spectra.yicho.restfulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class RestFulServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestFulServiceApplication.class, args);
    }

    // 기본 어플리케이션에 Bean을 등록하게 되면
    // 스프링부트가 초기화될떄 밑의 빈이 메모리에 올리감(생성됨)
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.KOREA);

        return localeResolver;
    }
}
