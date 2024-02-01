package com.teste.qrcode.service;

import com.teste.qrcode.domain.Salao;
import com.teste.qrcode.repository.SalaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaoService {
    private final SalaoRepository restauranteRepository;

    public List<Salao> getSalao(){
        return restauranteRepository.findAll();
    }
    public Salao addSalao(Salao student){
        return restauranteRepository.save(student);
    }

    public Salao findById(Integer id){
        return restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salão não encontrado"));
    }

}
