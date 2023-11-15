package pl.gamefactory.gameOfCard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@ComponentScan(basePackages = {"pl.gamefactory.gameOfCard"})
public class GameOfCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameOfCardApplication.class, args);
	}

}
