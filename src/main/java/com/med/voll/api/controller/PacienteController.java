package com.med.voll.api.controller;

import com.med.voll.api.model.paciente.PacienteDtoRequest;
import com.med.voll.api.model.paciente.PacienteDtoResponse;
import com.med.voll.api.model.paciente.PacienteDtoUpdate;
import com.med.voll.api.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    @Transactional
    public void cadastrar(@Valid @RequestBody PacienteDtoRequest pacienteDtoRequest){
        pacienteService.salvar(pacienteDtoRequest);
    }
    @GetMapping
    public Page<PacienteDtoResponse> listar(@PageableDefault(sort = {"nome"},direction = Sort.Direction.ASC) Pageable pageable){
        return pacienteService.listar(pageable);
    }

    @PutMapping
    @Transactional
    public void atualizar(@Valid @RequestBody PacienteDtoUpdate pacienteDtoUpdate){
        pacienteService.atualizar(pacienteDtoUpdate);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        pacienteService.deletar(id);
    }
}
