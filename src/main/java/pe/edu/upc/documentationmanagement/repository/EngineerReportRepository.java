package pe.edu.upc.documentationmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.documentationmanagement.entity.EngineerReport;

public interface EngineerReportRepository extends JpaRepository<EngineerReport, Long> {
}
