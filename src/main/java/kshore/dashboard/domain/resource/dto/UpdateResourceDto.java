package kshore.dashboard.domain.resource.dto;

import kshore.dashboard.domain.resource.entity.Resource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UpdateResourceDto {
    private String name;
    private String password;
    private String profileImg;

    public static UpdateResourceDto toDto(Resource resource) {
        return UpdateResourceDto.builder()
                .name(resource.getName())
                .password(resource.getPassword())
                .profileImg(resource.getProfileImg())
                .build();
    }
}