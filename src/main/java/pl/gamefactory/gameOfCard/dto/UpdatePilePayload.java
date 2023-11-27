package pl.gamefactory.gameOfCard.dto;

import lombok.Builder;

@Builder
public record UpdatePilePayload(String deckId, String pileName, int numberOfCards) {
}
