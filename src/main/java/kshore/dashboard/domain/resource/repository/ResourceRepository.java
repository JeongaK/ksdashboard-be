package kshore.dashboard.domain.resource.repository;

import kshore.dashboard.domain.resource.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, String> {
}
