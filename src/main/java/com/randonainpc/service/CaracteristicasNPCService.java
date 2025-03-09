package com.randonainpc.service;

import com.randonainpc.model.CaracteristicasNPC;
import com.randonainpc.repository.CaracteristicasNPCRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicasNPCService {

    //-> Injeto o repository
    private CaracteristicasNPCRepository repository;
    public CaracteristicasNPCService(CaracteristicasNPCRepository repository) {
        this.repository = repository;
    }

    //salvar
    public CaracteristicasNPC salvar(CaracteristicasNPC caracteristicasNPC) {
        return repository.save(caracteristicasNPC);
    }

    //lista
    public List<CaracteristicasNPC> listar() {
        return repository.findAll();
    }

    //TODO: Fazer os métodos: Listar por ID, Alterar e Deletar;

    //Listar por ID
    public CaracteristicasNPC buscarPorId(Long id) {
        Optional<CaracteristicasNPC> caracteristicasNPC = repository.findById(id);
        return caracteristicasNPC.get();
    }

    //Alterar

    //Deletar



}
