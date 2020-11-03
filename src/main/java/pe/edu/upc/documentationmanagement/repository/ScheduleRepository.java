package pe.edu.upc.documentationmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.documentationmanagement.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
