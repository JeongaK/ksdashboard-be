package kshore.dashboard.domain.resource.repository;

import kshore.dashboard.domain.resource.entity.Resource;
import kshore.dashboard.domain.test.dto.TestDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, String> {
}
