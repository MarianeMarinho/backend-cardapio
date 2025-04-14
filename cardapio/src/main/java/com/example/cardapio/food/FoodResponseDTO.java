package com.example.cardapio.food;

// Classe DTO (Data Transfer Object) usada para enviar apenas os dados necessários da entidade Food para o front-end
public record FoodResponseDTO(Long id, String title, String image, Integer price) {

    // Construtor que recebe um objeto Food (entidade do banco) e extrai apenas os dados que queremos enviar
    public FoodResponseDTO(Food food) {
        // Chama o construtor principal do record, passando os valores obtidos do objeto Food
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}
