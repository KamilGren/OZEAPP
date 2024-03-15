package pl.gren.oze_app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Ustawiając ścieżkę, na której ma być stosowany CORS
                .allowedOrigins("http://localhost:8080") // Ustawiając dozwolone domeny (adresy, z których przyjmowane są żądania)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Ustawiając dozwolone metody HTTP
                .allowCredentials(true) // Jeśli korzystasz z sesji użytkownika, ustawiając na true umożliwisz przesyłanie plików cookie
                .maxAge(3600); // Ustawiając czas, przez jaki przeglądarka może przechowywać informacje o tym, że dana domena jest zaufana (w sekundach)
    }
}