package com.med.voll.api.model.medico;

public record MedicoDtoResponse(Long id, String nome, String crm, String email, Especialidade especialidade) {
    public MedicoDtoResponse(Medico medico){
        this(medico.getId(),medico.getNome(), medico.getCrm(), medico.getEmail(),medico.getEspecialidade());
    }

}
