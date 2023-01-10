package xyz.zen.zfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zen.zfc.entity.StudySetEntity;

import java.util.List;
import java.util.UUID;

public interface StudySetRepository extends JpaRepository<StudySetEntity, UUID> {
    List<StudySetEntity> findByUserId(UUID userID);
}