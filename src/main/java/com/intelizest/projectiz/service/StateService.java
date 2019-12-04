package com.intelizest.projectiz.service;


import com.intelizest.projectiz.Entity.State;
import com.intelizest.projectiz.Repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    @Autowired
    StateRepository stateRepository;

    public List<State> getAllStateService(){
        List<State> report = stateRepository.getAllState();
        return report;
    }

    public State getStateByCodeService(String code){
        State result = stateRepository.getStateByCode(code);
        return result;
    }


    public boolean addStateService(State state){
        boolean returnvalue = stateRepository.addState(state);
        return returnvalue;
    }


    public boolean updateState(State state){
        return stateRepository.updateState(state);
    }

    public boolean deleteStateService(String code){
        return stateRepository.deleteState(code);
    }
}
