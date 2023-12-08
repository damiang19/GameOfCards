package pl.gamefactory.gameOfCard.dto;

import lombok.Builder;

import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
public record UpdatePilePayload(@NotNull String deckId, @NotNull String pileName, Integer numberOfCards, List<Cards> listOfCards) {
}
