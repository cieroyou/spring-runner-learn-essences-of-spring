package moviebuddy;

import moviebuddy.domain.CsvMovieReader;
import moviebuddy.domain.MovieFinder;
import moviebuddy.domain.MovieReader;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 객체를 생성하고 관리하는 역할
 */
@Configuration
public class MovieBuddyFactory {

    @Bean
    public MovieReader movieReader() {
        return new CsvMovieReader();
    }

    @Bean
    public MovieFinder movieFinder(MovieReader movieReader) {
        return new MovieFinder(movieReader);
    }
}
