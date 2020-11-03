package pe.edu.upc.documentationmanagement.service;


import pe.edu.upc.documentationmanagement.entity.ManagerRequest;

import java.util.List;
import java.util.Optional;

public interface ManagerRequestService {

    public List<ManagerRequest> findManagerRequestAll();

    public ManagerRequest createManagerRequest(ManagerRequest managerRequest);
    public ManagerRequest updateManagerRequest(ManagerRequest managerRequest);
    public ManagerRequest deleteManagerRequest(Long id);

    public Optional<ManagerRequest> getManagerRequest(Long id);
}
