package com.example.relationaldatabase.onetoone.bidirectionaljointable;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WorkStationServiceImpl implements WorkStationService {
    @NonNull
    private WorkStationRepository workStationRepository;

    private WorkStation findWorkInternal(Long id) {
        Optional<WorkStation> workStation = workStationRepository.findById(id);
        if (workStation.isEmpty()) {
            throw new RuntimeException();
        }
        return workStation.get();
    }

    @Override
    public String deleteWorkStation(Long id) {
        WorkStation workStation = findWorkInternal(id);
        workStationRepository.delete(workStation);

        return "deleted";
    }
}
