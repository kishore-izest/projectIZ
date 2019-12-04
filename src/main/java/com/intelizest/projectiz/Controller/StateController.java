package com.intelizest.projectiz.Controller;
import com.intelizest.projectiz.DTO.StateDTO;
import com.intelizest.projectiz.Entity.State;
import com.intelizest.projectiz.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StateController {

    @Autowired
    StateService stateService;

    @GetMapping("get-all-states")
    public List<State> getAllStates(){
        List<State> report = stateService.getAllStateService();
        return report;
    }

    @GetMapping("get-state-by-code")
    public ResponseEntity<State> getStateByCode(@RequestParam("code") String code){
        try{
            State search_result = stateService.getStateByCodeService(code);
            return new ResponseEntity<State>(search_result,HttpStatus.OK);

        }catch(Exception e)
        {
            return null;
        }
    }

    @PostMapping("add-new-state")
    public ResponseEntity<StateDTO> addState(@RequestBody State state){
        StateDTO stateDTO= new StateDTO();
        boolean value=stateService.addStateService(state);
        if(value){
            stateDTO.setMessage("Inserted the data into table");
        }else{
            stateDTO.setMessage("Couldn't insert data into the table");
            return new ResponseEntity<>(stateDTO, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(stateDTO,HttpStatus.OK);
    }

    @PutMapping("update-state")
    public ResponseEntity<StateDTO> updateState(@RequestBody State state){
        boolean updationSuccessful = stateService.updateState(state);
        StateDTO stateDTO= new StateDTO();
        if(updationSuccessful){
            stateDTO.setMessage("Updated the data ");
        }else{
            stateDTO.setMessage("Couldn't update data ");
            return new ResponseEntity<>(stateDTO,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(stateDTO,HttpStatus.OK);
    }

    @DeleteMapping("delete-state")
    public ResponseEntity<StateDTO> deleteState(@RequestParam String code){

        boolean deletionSuccessful = stateService.deleteStateService(code);
        StateDTO stateDTO = new StateDTO();

        if(deletionSuccessful)
            stateDTO.setMessage("Deleted the record");
        else{
            stateDTO.setMessage("Couldn't delete the record");
            return  new ResponseEntity<>(stateDTO,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(stateDTO,HttpStatus.OK);
    }
}
