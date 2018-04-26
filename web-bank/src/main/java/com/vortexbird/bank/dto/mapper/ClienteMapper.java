package com.vortexbird.bank.dto.mapper;

import com.vortexbird.bank.model.*;
import com.vortexbird.bank.model.Cliente;
import com.vortexbird.bank.model.control.*;
import com.vortexbird.bank.model.dto.ClienteDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class ClienteMapper implements IClienteMapper {
    private static final Logger log = LoggerFactory.getLogger(ClienteMapper.class);

    /**
    * Logic injected by Spring that manages TipoDocumento entities
    *
    */
    @Autowired
    ITipoDocumentoLogic logicTipoDocumento1;

    @Transactional(readOnly = true)
    public ClienteDTO clienteToClienteDTO(Cliente cliente)
        throws Exception {
        try {
            ClienteDTO clienteDTO = new ClienteDTO();

            clienteDTO.setClieId(cliente.getClieId());
            clienteDTO.setActivo((cliente.getActivo() != null)
                ? cliente.getActivo() : null);
            clienteDTO.setDireccion((cliente.getDireccion() != null)
                ? cliente.getDireccion() : null);
            clienteDTO.setEmail((cliente.getEmail() != null)
                ? cliente.getEmail() : null);
            clienteDTO.setNombre((cliente.getNombre() != null)
                ? cliente.getNombre() : null);
            clienteDTO.setTelefono((cliente.getTelefono() != null)
                ? cliente.getTelefono() : null);
            clienteDTO.setTdocId_TipoDocumento((cliente.getTipoDocumento()
                                                       .getTdocId() != null)
                ? cliente.getTipoDocumento().getTdocId() : null);

            return clienteDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Cliente clienteDTOToCliente(ClienteDTO clienteDTO)
        throws Exception {
        try {
            Cliente cliente = new Cliente();

            cliente.setClieId(clienteDTO.getClieId());
            cliente.setActivo((clienteDTO.getActivo() != null)
                ? clienteDTO.getActivo() : null);
            cliente.setDireccion((clienteDTO.getDireccion() != null)
                ? clienteDTO.getDireccion() : null);
            cliente.setEmail((clienteDTO.getEmail() != null)
                ? clienteDTO.getEmail() : null);
            cliente.setNombre((clienteDTO.getNombre() != null)
                ? clienteDTO.getNombre() : null);
            cliente.setTelefono((clienteDTO.getTelefono() != null)
                ? clienteDTO.getTelefono() : null);

            TipoDocumento tipoDocumento = new TipoDocumento();

            if (clienteDTO.getTdocId_TipoDocumento() != null) {
                tipoDocumento = logicTipoDocumento1.getTipoDocumento(clienteDTO.getTdocId_TipoDocumento());
            }

            if (tipoDocumento != null) {
                cliente.setTipoDocumento(tipoDocumento);
            }

            return cliente;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ClienteDTO> listClienteToListClienteDTO(
        List<Cliente> listCliente) throws Exception {
        try {
            List<ClienteDTO> clienteDTOs = new ArrayList<ClienteDTO>();

            for (Cliente cliente : listCliente) {
                ClienteDTO clienteDTO = clienteToClienteDTO(cliente);

                clienteDTOs.add(clienteDTO);
            }

            return clienteDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Cliente> listClienteDTOToListCliente(
        List<ClienteDTO> listClienteDTO) throws Exception {
        try {
            List<Cliente> listCliente = new ArrayList<Cliente>();

            for (ClienteDTO clienteDTO : listClienteDTO) {
                Cliente cliente = clienteDTOToCliente(clienteDTO);

                listCliente.add(cliente);
            }

            return listCliente;
        } catch (Exception e) {
            throw e;
        }
    }
}
