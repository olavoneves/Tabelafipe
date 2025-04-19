package br.com.tabelafipe.service;

import java.util.List;

public interface IConverteTabelafipeService {
    <T> T obterDados(String json, Class<T> dadoVeiculo);
    <T> List<T> obterLista(String json, Class<T> dadoVeiculo);
}
