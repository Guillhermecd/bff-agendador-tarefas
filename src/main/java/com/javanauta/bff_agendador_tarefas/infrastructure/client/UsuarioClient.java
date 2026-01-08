package com.javanauta.bff_agendador_tarefas.infrastructure.client;

import com.javanauta.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.in.LoginRequestoDTO;
import com.javanauta.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.dto.out.ViaCepDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")

public interface UsuarioClient {

    //buscar onde o findByEmail está buscando na API usuario
    @GetMapping
    UsuarioDTOResponse buscarUsuarioPorEmail(@RequestParam("email") String email,
                                             @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestoDTO usuarioDTO);


    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                            @RequestHeader("Authorization") String token);
    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestHeader("Authorization") String token);
    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestHeader("Authorization") String token);

    @GetMapping ("/endereco/{cep}")
    ViaCepDTOResponse buscarDadosCep(@PathVariable("cep") String cep);
    }

