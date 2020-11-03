package pe.edu.upc.documentationmanagement.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.documentationmanagement.entity.ManagerRequest;
import pe.edu.upc.documentationmanagement.repository.ManagerRequestRepository;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class ManagerRequestServiceImpl implements ManagerRequestService {

    @Autowired
    ManagerRequestRepository managerRequestRepository;



    @Override
    public List<ManagerRequest> findManagerRequestAll() {
        return managerRequestRepository.findAll();
    }

    @Override
    public ManagerRequest createManagerRequest(ManagerRequest managerRequest) {
        return managerRequestRepository.save(managerRequest);
    }

    @Override
    public ManagerRequest updateManagerRequest(ManagerRequest managerRequest) {
        return managerRequestRepository.save(managerRequest);
    }

    @Override
    public Optional<ManagerRequest> getManagerRequest(Long id) {
        return managerRequestRepository.findById(id);
    }


    @Override
    public ManagerRequest deleteManagerRequest(Long id) {
        managerRequestRepository.deleteById(id);
        return null;
    }



}
