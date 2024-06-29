package com.med.voll.api.model.medico;


import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Table(name = "medicos")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(value = EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private Boolean ativo = true;

    public Medico(MedicoDtoRequest medicoDtoRequest) {
        this.nome = medicoDtoRequest.nome();
        this.email = medicoDtoRequest.email();
        this.telefone = medicoDtoRequest.telefone();
        this.crm = medicoDtoRequest.crm();
        this.especialidade = medicoDtoRequest.especialidade();
        this.endereco = new Endereco(medicoDtoRequest.endereco());
    }

    public void atualizar(MedicoDtoUpdate medicoDtoUpdate) {
        if (medicoDtoUpdate.nome() != null) {
            this.nome = medicoDtoUpdate.nome();
        }if (medicoDtoUpdate.telefone() != null) {
            this.telefone = medicoDtoUpdate.telefone();
        }if (medicoDtoUpdate.endereco() != null) {
            this.endereco.atualizar(medicoDtoUpdate.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
