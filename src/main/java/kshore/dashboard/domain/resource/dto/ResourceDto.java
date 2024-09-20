package kshore.dashboard.domain.resource.dto;

import jakarta.persistence.*;
import kshore.dashboard.domain.resource.entity.*;
import kshore.dashboard.util.enums.ExpLevel;
import kshore.dashboard.util.enums.Gender;
import kshore.dashboard.util.enums.KoreanLevel;
import kshore.dashboard.util.enums.ResourceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResourceDto {
    private String resourceId;
    private List<ResourceSkill> resourceSkills = new ArrayList<>();
    private List<ResourceRole> resourceRoles = new ArrayList<>();
    private String name;
    private String password;
    private String email;
    private Gender gender;
    private ResourceStatus resourceStatus;
    private ExpLevel expLevel;
    private KoreanLevel koreanLevel;
    private String mainSkill;
    private Integer accessLevel;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String profileImg;
    private Integer graduationYear;
    private LocalDate terminationDate;
    private LocalDate birthDate;

    public static ResourceDto toDto(Resource resource) {
        return ResourceDto.builder()
                .resourceId(resource.getResourceId())
                .resourceSkills(resource.getResourceSkills())
                .resourceRoles(resource.getResourceRoles())
                .name(resource.getName())
                .password(resource.getPassword())
                .email(resource.getEmail())
                .gender(resource.getGender())
                .resourceStatus(resource.getResourceStatus())
                .expLevel(resource.getExpLevel())
                .mainSkill(resource.getMainSkill())
                .accessLevel(resource.getAccessLevel())
                .createdAt(resource.getCreatedAt())
                .updatedAt(resource.getUpdatedAt())
                .profileImg(resource.getProfileImg())
                .graduationYear(resource.getGraduationYear())
                .terminationDate(resource.getTerminationDate())
                .birthDate(resource.getBirthDate())
                .build();
    }
}
