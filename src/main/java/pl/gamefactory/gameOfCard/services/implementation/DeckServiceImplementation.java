package pl.gamefactory.gameOfCard.services.implementation;

import org.springframework.stereotype.Service;
import pl.gamefactory.gameOfCard.entities.Deck;
import pl.gamefactory.gameOfCard.entities.User;
import pl.gamefactory.gameOfCard.entities.enums.Cards;
import pl.gamefactory.gameOfCard.repository.DeckRepository;
import pl.gamefactory.gameOfCard.services.DeckService;
import pl.gamefactory.gameOfCard.services.UserService;
import pl.gamefactory.gameOfCard.utils.SecurityUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DeckServiceImplementation implements DeckService {

    private final DeckRepository deckRepository;

    private final UserService userService;

    public DeckServiceImplementation(DeckRepository deckRepository, UserService userService) {
        this.deckRepository = deckRepository;
        this.userService = userService;
    }


    @Override
    public Deck createDeck() {
        Deck deck = new Deck();
        deck.setId(1L);
        List<Cards> cardsList = new ArrayList<>(List.of(Cards.values()));
        Collections.shuffle(cardsList);
        deck.setCards(cardsList);
        return deckRepository.save(deck);
    }

    List<Cards> getCardsAndUpdateDeck(){
        User user = userService.findByUsername(SecurityUtils.getCurrentUserLogin().get());
        Optional<Deck> deck = deckRepository.findById(user.getDeckId());
        user.setCards(updateCards(user.getCards(),deck.get()));
        return userService.save(user).getCards();
    }

    List<Cards> updateCards(List<Cards> list, Deck deck) {
        int deckSize = deck.getCards().size();
        if (list.size() < 5 && deckSize != 0) {
            int cardsToGet = 5 - list.size();
            if (deckSize >= cardsToGet) {
                for (int i = 0; i < cardsToGet; i++) {
                    deckSize = deck.getCards().size();
                    list.add(deck.getCards().get(deckSize- 1));
                }
            if(deckSize < cardsToGet){
                for(Cards card : deck.getCards()){
                    list.add(card);
                    deck.getCards().remove(card);
                }
            }

            }
            deckRepository.save(deck);
        }
        return list;
    }
}
