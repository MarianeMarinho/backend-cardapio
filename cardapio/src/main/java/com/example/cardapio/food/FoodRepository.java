package com.example.cardapio.food;

// Importa a interface JpaRepository que fornece metodos prontos para acessar o banco de dados
import org.springframework.data.jpa.repository.JpaRepository;

// Essa interface é um repositório de dados para a entidade Food
// JpaRepository já oferece métodos como findAll(), findById(), save(), delete() etc.
public interface FoodRepository extends JpaRepository<Food, Long> {
    // O primeiro parametro é a entidade (Food)
    // O segundo é o tipo do ID da entidade (Long)


}
