package kshore.dashboard.domain.resource.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "skill_tag")
public class SkillTag {

    @Id
    @Column(name = "skill_name")
    private String skillName;

    @CreatedDate
    private LocalDateTime createdAt;

    private boolean isActive;
}
