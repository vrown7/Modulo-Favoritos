package cl.duoc.backend_api.controller;

import cl.duoc.backend_api.model.Favorito;
import cl.duoc.backend_api.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoRepository repository;

    @PostMapping("/agregar")
    public ResponseEntity<Favorito> agregar(@RequestBody Favorito favorito) {
        return new ResponseEntity<>(repository.save(favorito), HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Favorito>> listarPorUsuario(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findByUsuarioId(id), HttpStatus.OK);
    }
}
