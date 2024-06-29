package com.med.voll.api.service;

import com.med.voll.api.model.medico.Medico;
import com.med.voll.api.model.medico.MedicoDtoRequest;
import com.med.voll.api.model.medico.MedicoDtoResponse;
import com.med.voll.api.model.medico.MedicoDtoUpdate;
import com.med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    public void salvar(MedicoDtoRequest medicoDtoRequest){
        medicoRepository.save(new Medico(medicoDtoRequest));
    }

    public Page<MedicoDtoResponse> listar(Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao).map(MedicoDtoResponse::new);
    }

    public void atualizar(MedicoDtoUpdate medicoDtoUpdate) {

        var medico = medicoRepository.getReferenceById(medicoDtoUpdate.id());
        medico.atualizar(medicoDtoUpdate);

    }

    public void apagar(Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }
}
