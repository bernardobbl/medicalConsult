package br.com.jaircunha.medicalconsult.consulta.service;

import br.com.jaircunha.medicalconsult.consulta.domain.Consulta;
import br.com.jaircunha.medicalconsult.consulta.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta cadastrarConsulta(Consulta consulta){
        consulta.setIdConsulta(null);
        return consultaRepository.save(consulta);
    }
}
