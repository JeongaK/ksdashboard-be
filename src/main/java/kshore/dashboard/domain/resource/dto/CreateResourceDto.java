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
public class CreateResourceDto {
    private String name;
    private String password;
    private String email;

    public static CreateResourceDto toDto(Resource resource) {
        return CreateResourceDto.builder()
                .name(resource.getName())
                .password(resource.getPassword())
                .email(resource.getEmail())
                .build();
    }
}
