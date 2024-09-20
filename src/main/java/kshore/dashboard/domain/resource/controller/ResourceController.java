package kshore.dashboard.domain.resource.controller;

import kshore.dashboard.domain.resource.dto.CreateResourceDto;
import kshore.dashboard.domain.resource.dto.ResourceDto;
import kshore.dashboard.domain.resource.entity.Resource;
import kshore.dashboard.domain.resource.service.ResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@Slf4j
@RequiredArgsConstructor
@RestController
public class ResourceController {
    private final ResourceService resourceService;

    @GetMapping("/resource/{id}")
    public ResponseEntity<?> getResourceById(@PathVariable String id) {
        log.info("controller - getResourceById: {}", id);
        Resource resource = resourceService.getResourceById(id);
        log.info("success to getResourceById");
        return ResponseEntity.ok(resource);
    }

    @PostMapping("/resource/signup")
    public ResponseEntity<?> createResource(@RequestBody CreateResourceDto dto){
        log.info("controller.createResource: {}", dto);
        Resource resource = resourceService.saveResource(Resource.toEntity(dto));
        log.info("success to controller.createResource");
        return ResponseEntity.status(HttpStatus.CREATED).body(resource);
    }

}
