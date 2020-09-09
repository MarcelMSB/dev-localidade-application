package dev.marcel.localidade.model.ibge.feign.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MesorregiaoDto {

    private String nome;

    public String getNome() {
        return nome;
    }
}