package kshore.dashboard.domain.resource.repository;

import kshore.dashboard.domain.resource.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResourceRepository extends JpaRepository<Resource, String> {
    Optional<Resource> findByEmail(String email);




}
