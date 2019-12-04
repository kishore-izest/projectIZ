package com.intelizest.projectiz.Repository;

import com.intelizest.projectiz.Entity.State;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class StateRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<State> getAllState(){
        String hqlQuery="From State";
        List<State> report = entityManager.createQuery(hqlQuery).getResultList();
        return report;
    }

    public State getStateByCode(String code){
        String hqlQuery = "From State as c where c.code=?1";
        State result = (State) entityManager.createQuery(hqlQuery).setParameter(1,code).getSingleResult();
        return result;

    }
    
    public boolean addState(State state){
        entityManager.persist(state);
        return true;
    }

    public boolean updateState(State state){

        try{
            State updatedState = entityManager.find(State.class,state.getCode());
            updatedState.setDescription(state.getDescription());
            entityManager.flush();
            return true;
        }catch(Exception e){
            return  false;
        }


    }

    public boolean deleteState(String code){
        try{
            State selectedState = entityManager.find(State.class,code);

            entityManager.remove(selectedState);

        }catch (Exception e){
            return false;
        }
        return true;
    }
}
