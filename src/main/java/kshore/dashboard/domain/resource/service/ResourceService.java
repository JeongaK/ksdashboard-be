package kshore.dashboard.domain.resource.service;

import kshore.dashboard.domain.resource.dto.ResourceDto;
import kshore.dashboard.domain.resource.entity.Resource;
import kshore.dashboard.domain.resource.repository.ResourceRepository;
import kshore.dashboard.util.enums.Gender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ResourceService {
    private final ResourceRepository resourceRepository;

    public Resource getResourceById(String id){
        log.info("Call API : getResourceById");
        Optional<Resource> optionalResource = resourceRepository.findById(id);
        return optionalResource.orElse(null);
    }

    // create one resource
    public Resource saveResource(Resource resource){
        log.info("Call API : saveResource");
        return resourceRepository.save(resource);
    }
}
