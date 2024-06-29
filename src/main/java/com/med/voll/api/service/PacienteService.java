package com.med.voll.api.service;

import com.med.voll.api.model.medico.MedicoDtoUpdate;
import com.med.voll.api.model.paciente.Paciente;
import com.med.voll.api.model.paciente.PacienteDtoRequest;
import com.med.voll.api.model.paciente.PacienteDtoResponse;
import com.med.voll.api.model.paciente.PacienteDtoUpdate;
import com.med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public void salvar(PacienteDtoRequest pacienteDtoRequest){
        pacienteRepository.save(new Paciente(pacienteDtoRequest));
    }

    public Page<PacienteDtoResponse> listar(Pageable pageable) {
        return pacienteRepository.findAll(pageable).map(PacienteDtoResponse::new);
    }

    public void atualizar(PacienteDtoUpdate pacienteDtoUpdate) {
        var paciente = pacienteRepository.getReferenceById(pacienteDtoUpdate.id());
        paciente.atualizar(pacienteDtoUpdate);
    }

    public void deletar(Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.apagar();
    }
}
