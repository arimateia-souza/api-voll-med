package com.med.voll.api.model.medico;

import com.med.voll.api.model.EnderecoDtoRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoDtoUpdate(@NotNull Long id,
                              String nome,
                              @NotBlank String telefone,
                              @Valid EnderecoDtoRequest endereco) {
}
