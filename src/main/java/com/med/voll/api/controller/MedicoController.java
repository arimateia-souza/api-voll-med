package com.med.voll.api.controller;


import com.med.voll.api.model.medico.MedicoDtoRequest;
import com.med.voll.api.model.medico.MedicoDtoResponse;
import com.med.voll.api.model.medico.MedicoDtoUpdate;
import com.med.voll.api.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid MedicoDtoRequest medicoDtoRequest){
        medicoService.salvar(medicoDtoRequest);
    }

    @GetMapping
    public Page<MedicoDtoResponse> listar(@PageableDefault(size = 2,sort = {"nome"},direction = Sort.Direction.ASC) Pageable pageable){
        return medicoService.listar(pageable);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid MedicoDtoUpdate medicoDtoUpdate){
        medicoService.atualizar(medicoDtoUpdate);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void apagar(@PathVariable Long id){
        medicoService.apagar(id);
    }

}
