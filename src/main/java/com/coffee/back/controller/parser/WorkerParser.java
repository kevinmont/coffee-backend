package com.coffee.back.controller.parser;

import com.coffee.back.commons.dto.WorkerDTO;
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
        workerDTO.setId(workerVO.getId());
        workerDTO.setWorkerName(workerVO.getName());
        workerDTO.setLastName(workerVO.getLastName());
        workerDTO.setAddress(workerVO.getAddress());
        workerDTO.setEmail(workerVO.getEmail());
        workerDTO.setPhoneNumber(workerVO.getPhoneNumber());
        workerDTO.setPhoto(workerVO.getPhoto());
        workerDTO.setUserDTO(UserParser.parseToUserDTO(workerVO.getUserVO()));
        workerDTO.getUserDTO().setWorkerId(workerVO.getId());
        return workerDTO;
    }
}
