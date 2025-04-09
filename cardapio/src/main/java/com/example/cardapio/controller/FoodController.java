
package com.example.cardapio.controller;

// Importa a classe que representa os dados dos alimentos
import com.example.cardapio.food.Food;

// Importa o repositório que acessa os dados no banco de dados
import com.example.cardapio.food.FoodRepository;

// Permite que o Spring injete automaticamente dependências (como o repositório)
import org.springframework.beans.factory.annotation.Autowired;

// Usado para mapear requisições GET (ex: quando o usuário acessa via navegador ou API)
import org.springframework.web.bind.annotation.GetMapping;

// Define a rota base da controller (prefixo da URL)
import org.springframework.web.bind.annotation.RequestMapping;

// Indica que essa classe é uma controller que responde como API (REST)
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Informa ao Spring que essa classe vai responder requisições HTTP
@RestController

// Define que essa controller responde requisições que começam com /food
@RequestMapping("food")
public class FoodController {


    // Injeta automaticamente o repositório no controller
    @Autowired
    private FoodRepository repository;

    // Metodo que responde requisições GET para /food
    @GetMapping

    public List<Food> getAll() {

        // Busca todos os registros de comida no banco de dados
        List<Food> foodList = repository.findAll();
        return foodList;


    }
}