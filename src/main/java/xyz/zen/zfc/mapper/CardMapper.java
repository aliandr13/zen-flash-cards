package xyz.zen.zfc.mapper;

import org.springframework.stereotype.Component;
import xyz.zen.zfc.entity.CardEntity;
import xyz.zen.zfc.model.Card;

@Component
public class CardMapper {

    public Card map(CardEntity entity) {
        return Card.builder()
                .id(entity.getId())
                .setId(entity.getSetId())
                .userId(entity.getUserId())
                .term(entity.getTerm())
                .definition(entity.getDefinition())
                .description(entity.getDescription())
                .build();
    }

    public CardEntity map(Card model) {
        return CardEntity.builder()
                .id(model.getId())
                .userId(model.getUserId())
                .setId(model.getSetId())
                .term(model.getTerm())
                .definition(model.getDefinition())
                .description(model.getDescription())
                .build();
    }

}
