package com.med.voll.api.model.paciente;

import com.med.voll.api.model.EnderecoDtoRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteDtoRequest(@NotBlank String nome,
                                 @NotBlank @Email String email,
                                 @NotBlank String telefone,
                                 @NotBlank @Pattern(regexp = "\\d{11}") String cpf,
                                 @NotNull @Valid EnderecoDtoRequest endereco) {
}
