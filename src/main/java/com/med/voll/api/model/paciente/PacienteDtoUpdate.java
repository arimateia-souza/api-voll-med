package com.med.voll.api.model.paciente;

import com.med.voll.api.model.EnderecoDtoRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record PacienteDtoUpdate(@NotNull Long id,
                                String nome,
                                String telefone,
                                @Valid EnderecoDtoRequest endereco) {
}
