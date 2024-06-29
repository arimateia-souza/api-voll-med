package com.med.voll.api.model.medico;

import com.med.voll.api.model.EnderecoDtoRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDtoRequest(@NotBlank String nome,
                               @NotBlank @Email String email,
                               @NotBlank String telefone,
                               @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
                               @NotNull Especialidade especialidade,
                               @NotNull @Valid EnderecoDtoRequest endereco) {

}
