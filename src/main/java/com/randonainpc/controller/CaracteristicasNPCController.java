package com.randonainpc.controller;

import com.randonainpc.model.CaracteristicasNPC;
import com.randonainpc.repository.CaracteristicasNPCRepository;
import com.randonainpc.service.CaracteristicasNPCService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AventuraController
@RequestMapping("/caracteristicas")
public class CaracteristicasNPCController {


    private final CaracteristicasNPCRepository caracteristicasNPCRepository;

    @GetMapping("/bemvindo")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem a acessar")
    public String bemvindo() {
        return "Bem vindo a minha API";
    }
    // -> Service injection

    private final CaracteristicasNPCService caracteristicasNPCService;

    public CaracteristicasNPCController(CaracteristicasNPCService caracteristicasNPCService, CaracteristicasNPCRepository caracteristicasNPCRepository) {
        this.caracteristicasNPCService = caracteristicasNPCService;
        this.caracteristicasNPCRepository = caracteristicasNPCRepository;
    }

    //post
    @PostMapping("/novonpc")
    @Operation(summary = "Cria um novo NPC", description = "Esta rota cria um novo NPC no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "NPC criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Não foi possível criar o NPC")
    })
    public ResponseEntity<CaracteristicasNPC> criar(@RequestBody CaracteristicasNPC caracteristicasNPC) {
        CaracteristicasNPC salvo = caracteristicasNPCService.salvar(caracteristicasNPC);
        return ResponseEntity.ok(salvo);
    }

    //get
    @GetMapping("/listar")
    @Operation(summary = "Lista todos os PJs cadastrados", description = "Esta rota mostra todos os jogadores cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Jogadores localizados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Jogadores não encontrados")
    })
    public ResponseEntity<List<CaracteristicasNPC>> listar() {
        List<CaracteristicasNPC> NPCs = caracteristicasNPCService.listar();
        return ResponseEntity.ok(NPCs);
    }

    //get por ID
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista os PJs por ID", description = "Esta rota mostra os jogadores por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Jogador localizados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Jogador não encontrados")
    })
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        CaracteristicasNPC caracteristicas = caracteristicasNPCService.buscarPorId(id);
        if (caracteristicas != null) {
            return ResponseEntity.ok(caracteristicas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("o personagem do com o ID: (" + id + " ) não existe no banco de dados");
        }
    }

    // Atualizar NPC por ID
    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualizado o NPC por ID", description = "Esta rota atualiza um NPC por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Jogador atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Jogador não encontrado")
    })
    public ResponseEntity<?> atualizarNPC(
            @Parameter(description = "O usuário manda um ID no caminho de requisição")
            @PathVariable Long id,
            @Parameter(description = "O usuário manda os dados do NPC a serem atualizados")
            @RequestBody CaracteristicasNPC caracteristicasNPC) {

        CaracteristicasNPC npcAtualizado = caracteristicasNPCService.atualizarNPC(id, caracteristicasNPC);
        if (npcAtualizado != null) {
            return ResponseEntity.ok(npcAtualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O personagem com o ID: (" + id + ") não existe no banco de dados.");
        }
    }

    //delete
    @DeleteMapping("deletar/{id}")
    @Operation(summary = "Deleta os jogadores por ID", description = "Esta rota deleta um PJ do banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Jogador deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Jogador não encontrados")
    })
    public ResponseEntity<String> deletarPorId(
            @Parameter(description = "O usuário manda um ID no caminho de requisição")
            @PathVariable Long id) {
        if(caracteristicasNPCService.buscarPorId(id) != null) {
            caracteristicasNPCService.deletarPorId(id);
            return ResponseEntity.ok("O PJ com o id: (" + id + "), foi deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O PJ com o id: (" + id + "), não foi encontrado");
        }
    }
}
