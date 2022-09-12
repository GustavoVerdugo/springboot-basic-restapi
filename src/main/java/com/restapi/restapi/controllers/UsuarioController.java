package com.restapi.restapi.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.restapi.restapi.models.UsuarioModel;
import com.restapi.restapi.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping( path = "/{id}" )
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){ 
        return usuarioService.obtenerPorId(id);
    }

    @GetMapping( path = "/query" )
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping( path = ("/{id}") )
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = usuarioService.eliminarUsuario(id);
        if (ok) return "Se elimino el usuario con id "+id;
        else return "No se elimino el usuario con id "+id;
    }
}
