package com.buffettinc.hrms.service.training;

import com.buffettinc.hrms.model.training.TrainingModule;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.UUID;

/**
 * This interface provides a contract for the TrainingModuleService. It includes CRUD methods for
 * handling Training Modules.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface TrainingModuleService {

    /**
     * Saves or updates a training module.
     *
     * @param trainingModule The training module to be saved or updated.
     * @return The saved or updated training module.
     */
    TrainingModule saveOrUpdateTrainingModule(TrainingModule trainingModule);

    /**
     * Gets a training module by ID.
     *
     * @param trainingID The ID of the training module.
     * @return The training module.
     */
    TrainingModule getTrainingModuleById(Long trainingID);

    /**
     * Gets all training modules.
     *
     * @return A list of all training modules.
     */
    List<TrainingModule> getAllTrainingModules();

    /**
     * Deletes a training module.
     *
     * @param trainingID The ID of the training module to delete.
     */
    void deleteTrainingModule(Long trainingID);
}
