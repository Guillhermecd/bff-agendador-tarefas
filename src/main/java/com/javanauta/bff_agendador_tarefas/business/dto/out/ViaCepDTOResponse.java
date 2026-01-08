package com.javanauta.bff_agendador_tarefas.business.dto.out;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViaCepDTOResponse {
    public String cep;
    public String logradouro;
    public String complemento;
    public String bairro;
    public String localidade;
    public String unidade;
    public String uf;
    public String ibge;
    public String gia;
    public String estado;
    public String regiao;
    public String siafi;
    public String ddd;
}
