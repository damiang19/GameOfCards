package pl.gamefactory.gameOfCard.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record UpdatePilePayload(String deckId, String pileName, Integer numberOfCards, List<Cards> listOfCards) {
}
