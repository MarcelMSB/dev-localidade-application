package dev.marcel.localidade.model.ibge.feign;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Cache {

    public static Map<Long, String> movimentacoes = new HashMap<>();

    public String get(final Long id) {
        return movimentacoes.get(id);
    }

    public void add(final Long id, final String nome) {
        movimentacoes.put(id, nome);
    }
}
