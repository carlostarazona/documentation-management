package pe.edu.upc.documentationmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.documentationmanagement.entity.FinalReport;

public interface FinalReportRepository extends JpaRepository<FinalReport, Long> {
}
