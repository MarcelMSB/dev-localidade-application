package dev.marcel.localidade.model.ibge.feign;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonProcessingException;

import dev.marcel.localidade.common.feign.core.FeignRequest;
import dev.marcel.localidade.common.jackson.JacksonObjectMapperContextResolver;
import dev.marcel.localidade.model.ibge.feign.dto.EstadoDto;
import dev.marcel.localidade.model.ibge.feign.dto.MunicipioDto;
import dev.marcel.localidade.model.ibge.feign.dto.MunicipioEstadoDto;

@Dependent
public class IBGEApiRemoteService implements IBGEFeignService {

    public static final String IBGE_API_REMOTE = "IBGE_API_REMOTE";

    @Inject
    private FeignRequest feignRequest;
    @Inject
    private JacksonObjectMapperContextResolver contextResolver;
    @Inject
    private Cache cache;

    public IBGEFeignService request() {
        return feignRequest.create(IBGEFeignService.class, IBGE_API_REMOTE);
    }

    @Override
    public List<EstadoDto> getEstados() {
        return request().getEstados();
    }

    @Override
    public List<MunicipioDto> getMunicipios(Long uf) {
        return request().getMunicipios(uf);
    }

    public byte[] getMunicipiosCSV() {
        final String header = "idEstado;siglaEstado;regiaoNome;nomeCidade;nomeMesorregiao;nomeFormatado";
        final String template = "\"%s\";\"%s\";\"%s\";\"%s\";\"%s\";\"%s\"";
        final StringJoiner joiner = new StringJoiner("\n");
        joiner.add(header);
        getEstados().forEach(e -> {
            getMunicipios(e.getId()).forEach(m -> joiner.add(String.format(template,
                    e.getId(),
                    e.getSigla(),
                    e.getRegiao().getNome(),
                    m.getNome(),
                    m.getMicrorregiao().getMesorregiao().getNome(),
                    m.getNome() + "/" + e.getSigla())
            ));
        });
        return joiner.toString().getBytes();
    }

    public byte[] getMunicipiosJSON() throws JsonProcessingException {
        final List<MunicipioEstadoDto> list = new ArrayList<>();
        getEstados().forEach(e -> {
            getMunicipios(e.getId()).forEach(m -> list.add(new MunicipioEstadoDto(e.getId(),
                    e.getSigla(),
                    e.getRegiao().getNome(),
                    m.getNome(),
                    m.getMicrorregiao().getMesorregiao().getNome(),
                    m.getNome() + "/" + e.getSigla())
            ));
        });
        return contextResolver.createObjectMapper().writeValueAsString(list).getBytes();
    }

    @Override
    public MunicipioDto findMunicipio(Long id) {
        return request().findMunicipio(id);
    }

    public String findNomeMunicipio(Long id) {
        String nome = cache.get(id);
        if (nome != null) {
            return nome;
        }
        nome = findMunicipio(id).getNome();
        cache.add(id, nome);
        return nome;
    }
}
