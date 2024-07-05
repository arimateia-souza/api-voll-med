package com.med.voll.api.controller;


import com.med.voll.api.model.medico.Medico;
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
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid MedicoDtoRequest medicoDtoRequest, UriComponentsBuilder uriComponents){
        var medico = new Medico(medicoDtoRequest);
        medicoService.salvar(medico);
        var uri = uriComponents.path("/medico/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new MedicoDtoResponse(medico));
    }

    @GetMapping
    public ResponseEntity<Page<MedicoDtoResponse>> listar(@PageableDefault(size = 2,sort = {"nome"},direction = Sort.Direction.ASC) Pageable pageable){
        var page = medicoService.listar(pageable);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid MedicoDtoUpdate medicoDtoUpdate){
        var medico = medicoService.atualizar(medicoDtoUpdate);
        return ResponseEntity.ok(new MedicoDtoResponse(medico));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity apagar(@PathVariable Long id){
        medicoService.apagar(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = medicoService.buscarPorId(id);
        return ResponseEntity.ok(new MedicoDtoResponse(medico));
    }

}
