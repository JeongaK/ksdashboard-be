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
@Entity(name = "role_tag")
public class RoleTag {

    @Id
    @Column(name = "role_name")
    private String roleName;

    @CreatedDate
    private LocalDateTime createdAt;

    private boolean isActive;
}
