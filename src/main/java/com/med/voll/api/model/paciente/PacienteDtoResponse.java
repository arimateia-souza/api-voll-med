package com.med.voll.api.model.paciente;

public record PacienteDtoResponse(Long id,
                                  String nome,
                                  String email,
                                  String cpf) {

    public PacienteDtoResponse(Paciente paciente){
        this(paciente.getId(),paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }

}
