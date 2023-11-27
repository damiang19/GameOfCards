package pl.gamefactory.gameOfCard.entities;

import lombok.Builder;
import lombok.Getter;
import pl.gamefactory.gameOfCard.dto.Cards;
import java.util.List;


@Builder
@Getter
public class Pile {
    private String name;
    private List<Cards> cards;

}
