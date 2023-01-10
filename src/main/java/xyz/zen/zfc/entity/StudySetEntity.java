package xyz.zen.zfc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@Entity
@Table(name = "study_set")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudySetEntity extends BaseEntity {

    @Column(name = "user_id", nullable = false)
    UUID userId;

    @Column(name = "title", nullable = false, length = 120)
    String title;

    @Column(name = "subject", nullable = true, length = 120)
    String subject;

    @Column(name = "description", nullable = true, length = 255)
    String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudySetEntity that = (StudySetEntity) o;
        return Objects.equals(userId, that.userId) && Objects.equals(title, that.title) && Objects.equals(subject, that.subject) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, title, subject, description);
    }
}