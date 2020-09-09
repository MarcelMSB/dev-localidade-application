package dev.marcel.localidade.model.ibge.feign.dto;

public class MunicipioEstadoDto {

    private Long idEstado;
    private String siglaEstado;
    private String regiaoNome;
    private String nomeCidade;
    private String nomeMesorregiao;
    private String nomeFormatado;

    public MunicipioEstadoDto() {
    }

    public MunicipioEstadoDto(Long idEstado, String siglaEstado, String regiaoNome, String nomeCidade, String nomeMesorregiao, String nomeFormatado) {
        this.idEstado = idEstado;
        this.siglaEstado = siglaEstado;
        this.regiaoNome = regiaoNome;
        this.nomeCidade = nomeCidade;
        this.nomeMesorregiao = nomeMesorregiao;
        this.nomeFormatado = nomeFormatado;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public String getRegiaoNome() {
        return regiaoNome;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public String getNomeMesorregiao() {
        return nomeMesorregiao;
    }

    public String getNomeFormatado() {
        return nomeFormatado;
    }

}