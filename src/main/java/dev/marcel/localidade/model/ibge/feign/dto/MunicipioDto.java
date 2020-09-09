package dev.marcel.localidade.model.ibge.feign.dto;

public class MunicipioDto {

    private Long id;
    private String nome;
    private MicrorregiaoDto microrregiao;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public MicrorregiaoDto getMicrorregiao() {
        return microrregiao;
    }

}