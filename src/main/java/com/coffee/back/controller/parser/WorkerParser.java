package com.coffee.back.controller.parser;

import com.coffee.back.commons.dto.WorkerDTO;
import com.coffee.back.controller.vo.WorkerVO;

/**
 *
 * @author mont
 */
public class WorkerParser {
    
    public static WorkerDTO parseToWorkerDTO(WorkerVO workerVO){
        WorkerDTO workerDTO = new WorkerDTO();
        workerDTO.setWorkerName(workerVO.getName());
        workerDTO.setLastName(workerVO.getLastName());
        workerDTO.setAddress(workerVO.getAddress());
        workerDTO.setEmail(workerVO.getEmail());
        workerDTO.setPhoneNumber(workerVO.getPhoneNumber());
        workerDTO.setPhoto(workerVO.getPhoto());
        workerDTO.setUserDTO(UserParser.parseToUserDTO(workerVO.getUserVO()));
        return workerDTO;
    }
}