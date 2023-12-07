package pl.gamefactory.gameOfCard.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import pl.gamefactory.gameOfCard.dto.Cards;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document("deck")
@Builder
@Getter
@Setter
public class Deck {
    @Id
    private String id;
    private List<Cards> cards;
    private List<Pile> pile;
    private Integer remainingCards;
}
