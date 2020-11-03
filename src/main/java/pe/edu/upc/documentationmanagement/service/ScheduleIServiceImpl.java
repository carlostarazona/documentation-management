package pe.edu.upc.documentationmanagement.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.documentationmanagement.entity.Schedule;

import pe.edu.upc.documentationmanagement.repository.ScheduleRepository;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class ScheduleIServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;


    @Override
    public List<Schedule> findScheduleAll() {
        return scheduleRepository.findAll();

    }

    @Override
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule updateSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);

    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }


    @Override
    public Optional<Schedule> getSchedule(Long id) {
        return scheduleRepository.findById(id);

    }
}
