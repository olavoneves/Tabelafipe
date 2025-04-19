package br.com.tabelafipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConverteTabelafipeService implements IConverteTabelafipeService {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> dadoVeiculo) {
        try {
            return mapper.readValue(json, dadoVeiculo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> obterLista(String json, Class<T> dadoVeiculo) {
        try {
            CollectionType lista = mapper.getTypeFactory()
                    .constructCollectionType(List.class, dadoVeiculo);
            return mapper.readValue(json,  lista);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
