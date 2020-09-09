package dev.marcel.localidade.model.ibge.feign.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MicrorregiaoDto {

    private MesorregiaoDto mesorregiao;

    public MesorregiaoDto getMesorregiao() {
        return mesorregiao;
    }
}