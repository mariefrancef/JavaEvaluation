package fritz.mariefrance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import fritz.mariefrance.model.BikeModel;
import fritz.mariefrance.model.Status;

public interface BikeRepository extends JpaRepository<BikeModel, Long> {
    List<BikeModel> findByStatus(Status status);
}