// Essa classe desserializa um json para um objeto, e dependendo do que o objeto possa receber, os atributos populados
// serão diferentes. Um objeto ObjectMapper é instanciado e armazenado no atributo mapper. ObjectMapper é a principal
// classe da biblioteca Jackson usada para serialização e desserialização de JSON.

package br.com.alura.consultando_tabela_fipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConverteDados implements IConverteDados{

    // Classe similar ao Gson que tem métodos de desserialização
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

// Método obterDados
// O método obterDados é uma implementação da interface IConverteDados.
// Ele é genérico, o que significa que pode retornar um objeto de qualquer tipo (<T>).
// String json: A string JSON a ser desserializada.
// Class<T> classe: A classe do tipo ao qual o JSON deve ser convertido.
// mapper.readValue(json, classe) é chamado para desserializar o JSON na instância da classe fornecida.
// Se ocorrer uma JsonProcessingException, ela é capturada e lançada como uma RuntimeException.


// Funcionamento
// Quando o método obterDados é chamado com uma string JSON e uma classe, ele usa o ObjectMapper para converter o JSON em uma instância dessa classe.
// Se a desserialização for bem-sucedida, ele retorna a instância da classe com os dados preenchidos a partir do JSON.
// Se ocorrer uma exceção durante o processo de desserialização, uma RuntimeException é lançada com a causa original.