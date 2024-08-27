package com.rezende.propostaapp.service;

import com.rezende.propostaapp.dto.PropostaRequestDTO;
import com.rezende.propostaapp.dto.PropostaResponseDTO;
import com.rezende.propostaapp.entity.Proposta;
import com.rezende.propostaapp.mapper.PropostaMapper;
import com.rezende.propostaapp.repository.PropostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PropostaService {

    private PropostaRepository propostaRepository;

    public PropostaResponseDTO criar(PropostaRequestDTO requestDTO) {
        Proposta proposta = PropostaMapper.INSTANCE.convertRequestToProposta(requestDTO);
        propostaRepository.save(proposta);
        return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }

    public List<PropostaResponseDTO> obterPropostas() {
        return PropostaMapper.INSTANCE.convertListEntityToDto(propostaRepository.findAll());
    }
}
