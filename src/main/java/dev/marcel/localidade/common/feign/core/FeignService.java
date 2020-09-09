package dev.marcel.localidade.common.feign.core;

public interface FeignService<T> {

    public T call();
}
