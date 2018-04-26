package com.vortexbird.bank.rest.controllers;

import com.vortexbird.bank.dto.mapper.IClienteMapper;
import com.vortexbird.bank.model.*;
import com.vortexbird.bank.model.dto.ClienteDTO;
import com.vortexbird.bank.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClienteRestController {
    private static final Logger log = LoggerFactory.getLogger(ClienteRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IClienteMapper clienteMapper;

    @PostMapping(value = "/saveCliente")
    public void saveCliente(@RequestBody
    ClienteDTO clienteDTO) throws Exception {
        try {
            Cliente cliente = clienteMapper.clienteDTOToCliente(clienteDTO);

            businessDelegatorView.saveCliente(cliente);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteCliente/{clieId}")
    public void deleteCliente(@PathVariable("clieId")
    Long clieId) throws Exception {
        try {
            Cliente cliente = businessDelegatorView.getCliente(clieId);

            businessDelegatorView.deleteCliente(cliente);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateCliente/")
    public void updateCliente(@RequestBody
    ClienteDTO clienteDTO) throws Exception {
        try {
            Cliente cliente = clienteMapper.clienteDTOToCliente(clienteDTO);

            businessDelegatorView.updateCliente(cliente);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataCliente")
    public List<ClienteDTO> getDataCliente() throws Exception {
        try {
            return businessDelegatorView.getDataCliente();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getCliente/{clieId}")
    public ClienteDTO getCliente(@PathVariable("clieId")
    Long clieId) throws Exception {
        try {
            Cliente cliente = businessDelegatorView.getCliente(clieId);

            return clienteMapper.clienteToClienteDTO(cliente);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
