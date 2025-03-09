package com.randonainpc.controller;

import com.randonainpc.model.CaracteristicasNPC;
import com.randonainpc.service.CaracteristicasNPCService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caracteristicas")
public class CaracteristicasNPCController {


    @GetMapping("/bemvindo")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem a acessar")
    public String bemvindo() {
        return "Bem vindo a minha API";
    }
    // -> Service injection

    private final CaracteristicasNPCService caracteristicasNPCService;

    public CaracteristicasNPCController(CaracteristicasNPCService caracteristicasNPCService) {
        this.caracteristicasNPCService = caracteristicasNPCService;
    }

    //post
    @PostMapping("/novonpc")
    public ResponseEntity<CaracteristicasNPC> criar(@RequestBody CaracteristicasNPC caracteristicasNPC) {
        CaracteristicasNPC salvo = caracteristicasNPCService.salvar(caracteristicasNPC);
        return ResponseEntity.ok(salvo);
    }

    //get

    //update

    //delete


}
