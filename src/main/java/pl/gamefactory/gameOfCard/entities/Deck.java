package pl.gamefactory.gameOfCard.entities;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import pl.gamefactory.gameOfCard.entities.enums.Cards;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("deck")
@Builder
@Getter
public class Deck {
    @Id String id;
    List<Cards> cards;
    List<Pile> pile;
    Integer remainingCards;
}
