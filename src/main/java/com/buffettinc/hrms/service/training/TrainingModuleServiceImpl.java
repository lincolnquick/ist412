package com.buffettinc.hrms.service.training;

import com.buffettinc.hrms.model.training.TrainingModule;
import com.buffettinc.hrms.repository.training.TrainingModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * This class implements the {@link TrainingModuleService} interface, providing concrete
 * implementations for each method.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class TrainingModuleServiceImpl implements TrainingModuleService {
    @Autowired
    private TrainingModuleRepository trainingModuleRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingModule saveOrUpdateTrainingModule(TrainingModule trainingModule) {
        return trainingModuleRepository.save(trainingModule);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingModule getTrainingModuleById(UUID trainingID) {
        return trainingModuleRepository.findById(trainingID).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TrainingModule> getAllTrainingModules() {
        return trainingModuleRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteTrainingModule(UUID trainingID) {
        trainingModuleRepository.deleteById(trainingID);
    }
}
