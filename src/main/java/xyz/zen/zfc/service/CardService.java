package xyz.zen.zfc.service;

import org.springframework.stereotype.Service;
import xyz.zen.zfc.entity.CardEntity;
import xyz.zen.zfc.mapper.CardMapper;
import xyz.zen.zfc.model.Card;
import xyz.zen.zfc.repository.CardRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardService(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    public List<Card> getBySetId(UUID setId) {
        return cardRepository.findAllBySetId(setId).stream()
                .map(cardMapper::map).collect(Collectors.toList());
    }

    public Card create(Card card) {
        CardEntity saved = cardRepository.save(cardMapper.map(card));
        return cardMapper.map(saved);
    }


}
