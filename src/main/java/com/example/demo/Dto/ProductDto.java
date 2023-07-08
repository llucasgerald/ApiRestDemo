package com.example.demo.Dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDto(@NotBlank String nome, @NotNull Double valor) {
}
