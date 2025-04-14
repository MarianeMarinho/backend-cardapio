package com.example.cardapio.controller;

// Importa a classe que representa os dados dos alimentos
import com.example.cardapio.food.Food;

// Importa o repositório que acessa os dados no banco de dados
import com.example.cardapio.food.FoodRepository;

// Importa a classe DTO que será usada para retornar apenas os dados necessários da entidade Food
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;

// Usado para mapear requisições GET (ex: quando o usuário acessa via navegador ou API)
import org.springframework.web.bind.annotation.*;

// Define a rota base da controller (prefixo da URL)

// Indica que essa classe é uma controller que responde como API (REST)

import java.util.List;

// Informa ao Spring que essa classe vai responder requisições HTTP
@RestController

// Define que essa controller responde requisições que começam com /food
@RequestMapping("food")
public class FoodController {

    // Injeta automaticamente o repositório no controller
    @Autowired
    private FoodRepository repository;

    //Metodo que restringe as origens das chamadas de Api
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    // Metodo que responde requisições GET para /food
    @GetMapping
    public List<FoodResponseDTO> getAll() {

        // Busca todos os registros de comida no banco de dados
        // Converte cada objeto Food para um objeto FoodResponseDTO usando o construtor da DTO
        // Isso garante que apenas os dados necessários sejam enviados para o front-end, melhorando segurança e desempenho
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();

        // Retorna a lista de DTOs para o front-end
        return foodList;
    }



    //Metodo que restringe as origens das chamadas de Api
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    // Metodo que responde às requisições HTTP POST para o endpoint /food
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        // Converte os dados recebidos no corpo da requisição (DTO) para um objeto da entidade Food
        Food foodData = new Food(data);

        // Salva a entidade Food no repositório (provavelmente um banco de dados)
        repository.save(foodData);

        // Não há retorno, pois o método é void e apenas processa a requisição
        return;
    }

}
