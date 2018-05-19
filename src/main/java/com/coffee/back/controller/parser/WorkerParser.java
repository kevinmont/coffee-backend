package com.coffee.back.controller.parser;

import com.coffee.back.commons.dto.WorkerDTO;
import com.coffee.back.controller.vo.UserVO;
import com.coffee.back.controller.vo.WorkerVO;

/**
 * Clase parseadora de utilidad.
 * 
 * @author mont
 */
public class WorkerParser {

    /**
     * Parse una clase de tipo {@code WorkerVO} a un tipo {@code WorkerDTO}.
     *
     * @param workerVO
     * @return {WorkerDTO} El producto convertido
     */
    public static WorkerDTO parseToWorkerDTO(WorkerVO workerVO) {
        WorkerDTO workerDTO = new WorkerDTO();
        workerDTO.setWorkerName(workerVO.getName());
        workerDTO.setLastName(workerVO.getLastName());
        workerDTO.setAddress(workerVO.getAddress());
        workerDTO.setEmail(workerVO.getEmail());
        workerDTO.setPhoneNumber(workerVO.getPhoneNumber());
        workerDTO.setPhoto(workerVO.getPhoto());
        workerDTO.setUserDTO(UserParser.parseToUserDTO(workerVO.getUserVO()));
        if(workerVO.getId() == null){
            workerDTO.setId(0);
            workerDTO.getUserDTO().setWorkerId(0);
        }else{
            workerDTO.getUserDTO().setWorkerId(workerVO.getId());
            workerDTO.setId(workerVO.getId());    
        }
        return workerDTO;
    }
    
    /**
     * Parse para una clase de tipo {@code WorkerDTO} a {@code WorkerVO}
     * @param workerDTO
     * @return {@code WorkerVO} modelo para la vista.
     */
    public static WorkerVO parseToWorkerVO(WorkerDTO workerDTO) {
        WorkerVO workerVO = new WorkerVO();
        workerVO.setName(workerDTO.getWorkerName());
        workerVO.setLastName(workerDTO.getLastName());
        workerVO.setAddress(workerDTO.getAddress());
        workerVO.setEmail(workerDTO.getEmail());
        workerVO.setId(workerDTO.getId());
        workerVO.setPhoneNumber(workerDTO.getPhoneNumber());
        workerVO.setPhoto(workerDTO.getPhoto());
        UserVO userVO = new UserVO();
        userVO.setUserName(workerDTO.getUserDTO().getUserName());
        userVO.setPassword(workerDTO.getUserDTO().getPassword());
        userVO.setUserType(workerDTO.getUserDTO().getUserType());
        workerVO.setUserVO(userVO);
        return workerVO;
    }

}
