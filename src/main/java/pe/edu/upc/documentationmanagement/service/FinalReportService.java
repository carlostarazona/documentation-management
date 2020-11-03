package pe.edu.upc.documentationmanagement.service;


import pe.edu.upc.documentationmanagement.entity.FinalReport;

import java.util.List;
import java.util.Optional;

public interface FinalReportService {

    public List<FinalReport> findFinalReportAll();

    public FinalReport createFinalReport(FinalReport finalReport);
    public FinalReport updateFinalReport(FinalReport finalReport);
    public void deleteFinalReport(Long id);

    public Optional<FinalReport> getFinalReport(Long id);
}
