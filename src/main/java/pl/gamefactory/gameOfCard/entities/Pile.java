package pl.gamefactory.gameOfCard.entities;

import pl.gamefactory.gameOfCard.entities.enums.Cards;

import java.util.List;

public record Pile(String name, List<Cards> cards) {
}
