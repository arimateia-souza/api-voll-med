package com.med.voll.api.model.paciente;

import com.med.voll.api.model.medico.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Paciente(PacienteDtoRequest pacienteDtoRequest) {
        this.nome = pacienteDtoRequest.nome();
        this.email = pacienteDtoRequest.email();
        this.telefone = pacienteDtoRequest.telefone();
        this.cpf = pacienteDtoRequest.cpf();
        this.endereco = new Endereco(pacienteDtoRequest.endereco());
    }

//* refatorar
    public void atualizar(PacienteDtoUpdate pacienteDtoUpdate) {
        if (pacienteDtoUpdate.nome() != null) {
            this.nome = pacienteDtoUpdate.nome();
        }if (pacienteDtoUpdate.telefone() != null) {
            this.telefone = pacienteDtoUpdate.telefone();
        }if (pacienteDtoUpdate.endereco() != null) {
            this.endereco.atualizar(pacienteDtoUpdate.endereco());
        }
    }

    public void apagar() {
        this.ativo = false;
    }
}
