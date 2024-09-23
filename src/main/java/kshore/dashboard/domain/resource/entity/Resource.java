package kshore.dashboard.domain.resource.entity;

import jakarta.persistence.*;
import kshore.dashboard.domain.resource.dto.CreateResourceDto;
import kshore.dashboard.domain.resource.dto.ResourceDto;
import kshore.dashboard.domain.resource.dto.UpdateResourceDto;
import kshore.dashboard.util.enums.ExpLevel;
import kshore.dashboard.util.enums.Gender;
import kshore.dashboard.util.enums.KoreanLevel;
import kshore.dashboard.util.enums.ResourceStatus;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "resource")
public class Resource {

    @Id
    @Column(name = "resource_id", columnDefinition = "CHAR(36)")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String resourceId;

    @OneToMany(mappedBy = "resource")
    private List<ResourceSkill> resourceSkills = new ArrayList<>();

    @OneToMany(mappedBy = "resource")
    private List<ResourceRole> resourceRoles = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_name")
    private SkillTag skillTag;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private ResourceStatus resourceStatus;

    @Enumerated(EnumType.STRING)
    private ExpLevel expLevel;

    @Enumerated(EnumType.STRING)
    private KoreanLevel koreanLevel;

    private String mainSkill;

    private Integer accessLevel;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String profileImg;

    private Integer graduationYear;

    private LocalDate terminationDate;

    private LocalDate birthDate;

    public static  Resource toEntity(ResourceDto dto){
        return Resource.builder()
                .resourceId(dto.getResourceId())
//                .resourceSkills(dto.getResourceSkills())
//                .resourceRoles(dto.getResourceRoles())
                .name(dto.getName())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .gender(dto.getGender())
                .resourceStatus(dto.getResourceStatus())
                .expLevel(dto.getExpLevel())
                .mainSkill(dto.getMainSkill())
                .accessLevel(dto.getAccessLevel())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .profileImg(dto.getProfileImg())
                .graduationYear(dto.getGraduationYear())
                .terminationDate(dto.getTerminationDate())
                .birthDate(dto.getBirthDate())
                .build();
    }

    public static  Resource toEntity(CreateResourceDto dto){
        return Resource.builder()
                .name(dto.getName())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .build();
    }

    public static Resource toEntity(UpdateResourceDto dto) {
        return Resource.builder()
                .name(dto.getName())
                .password(dto.getPassword())
                .profileImg(dto.getProfileImg())
                .build();
    }
}
