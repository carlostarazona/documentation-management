package pe.edu.upc.documentationmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.documentationmanagement.entity.ManagerRequest;

public interface ManagerRequestRepository extends JpaRepository<ManagerRequest, Long> {
}
