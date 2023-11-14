package pl.gamefactory.gameOfCard.entities;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.gamefactory.gameOfCard.dto.Cards;

import java.util.List;

@Document("deck")
@Builder
@Getter
public class Pile {

    private String name;
    private List<Cards> cards;

}
