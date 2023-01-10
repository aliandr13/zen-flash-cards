package xyz.zen.zfc.mapper;

import org.springframework.stereotype.Component;
import xyz.zen.zfc.entity.StudySetEntity;
import xyz.zen.zfc.model.StudySet;

@Component
public class StudySetMapper {

    public StudySet map(StudySetEntity entity) {
        return StudySet.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .title(entity.getTitle())
                .subject(entity.getSubject())
                .description(entity.getDescription())
                .build();
    }

    public StudySetEntity map(StudySet model) {
        return StudySetEntity.builder()
                .id(model.getId())
                .userId(model.getUserId())
                .title(model.getTitle())
                .subject(model.getSubject())
                .description(model.getDescription())
                .build();
    }

}
