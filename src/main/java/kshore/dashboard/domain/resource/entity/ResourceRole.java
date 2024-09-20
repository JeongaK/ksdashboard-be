package kshore.dashboard.domain.resource.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "resource_role")
public class ResourceRole {
    @Id
    @Column(name = "resource_id", nullable = false)
    private String resourceId;

    @Id
    @Column(name = "role_name", nullable = false)
    private String roleName;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_name")
    private RoleTag roleTag;

}
