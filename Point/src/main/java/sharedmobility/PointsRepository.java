package sharedmobility;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="points", path="points")
public interface PointsRepository extends PagingAndSortingRepository<Points, Long>{
    List<Points> findByOrderId(Long id);
    List<Points> findByPointId(Long id);
}


