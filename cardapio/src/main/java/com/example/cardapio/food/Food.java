package com.example.cardapio.food;

// Importações necessárias para a persistência e uso do Lombok
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Define o nome da tabela no banco de dados
@Table(name = "foods")

// Indica que esta classe é uma entidade JPA
@Entity(name = "foods")

// Gera automaticamente os getters para todos os campos
@Getter

// Cria um construtor sem argumentos
@NoArgsConstructor

// Cria um construtor com todos os campos como argumentos
@AllArgsConstructor

// Gera os métodos equals e hashCode baseados apenas no campo "id"
@EqualsAndHashCode(of = "id")
public class Food {

    // Define o campo "id" como chave primária com geração automática (auto-incremento)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Armazena o título do prato
    private String title;

    // Armazena a URL ou caminho da imagem do prato
    private String image;

    // Armazena o preço do prato
    private Integer price;
}
