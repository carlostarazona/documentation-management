package pe.edu.upc.documentationmanagement.service;


import pe.edu.upc.documentationmanagement.entity.EngineerReport;

import java.util.List;
import java.util.Optional;

public interface EngineerReportService {

    public List<EngineerReport> findEngineerReportAll();

    public EngineerReport createEngineerReport(EngineerReport engineerReport);
    public EngineerReport updateEngineerReport(EngineerReport engineerReport);
    public void deleteEngineerReport(Long id);

    public Optional<EngineerReport> getEngineerReport(Long id);
}
