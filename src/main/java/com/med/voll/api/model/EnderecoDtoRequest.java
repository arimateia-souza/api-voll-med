package com.med.voll.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDtoRequest(@NotBlank String logradouro,
                                 String numero,
                                 String complemento,
                                 @NotBlank String bairro,
                                 @NotBlank String cidade,
                                 @NotBlank String uf,
                                 @Pattern(regexp = "\\d{8}") String cep) {
}
