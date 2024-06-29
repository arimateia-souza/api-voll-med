package com.med.voll.api.model.medico;


import com.med.voll.api.model.EnderecoDtoRequest;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public Endereco(EnderecoDtoRequest endereco) {
        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.bairro = endereco.bairro();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.cep = endereco.cep();
    }

    public void atualizar(EnderecoDtoRequest endereco) {
        if (endereco.logradouro() != null) {
            this.logradouro = endereco.logradouro();
        }if (endereco.numero() != null) {
            this.numero = endereco.numero();
        }if (endereco.logradouro() != null) {
            this.complemento = endereco.complemento();
        }if (endereco.bairro() != null) {
            this.bairro = endereco.bairro();
        }if (endereco.uf() != null) {
            this.uf = endereco.uf();
        }if (endereco.cep() != null) {
            this.cep = endereco.cep();
        }
    }
}
