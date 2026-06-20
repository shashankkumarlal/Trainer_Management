package com.service;

import com.dao.TrainerDAO;
import com.entities.Trainer;

import java.util.List;

public class TrainerService {
    private final TrainerDAO trainerDAO = new TrainerDAO();

    public Trainer registerTrainer(Trainer t){
        trainerDAO.addTrainer(t);
        return t;
    }

    public void updateTrainer(Trainer t){
        trainerDAO.updateTrainer(t);
    }

    public void deleteTrainer(Long id){
        trainerDAO.deleteTrainer(id);
    }

    public Trainer searchTrainer(Long id){
        return trainerDAO.getTrainerById(id);
    }

    public List<Trainer> displayAll(){
        return trainerDAO.showAllTrainer();
    }
}
