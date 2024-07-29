package luizbr.controller;

import luizbr.domain.model.Tarefa;
import luizbr.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final UserService userService;

    public TarefaController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable Long id){
        var tarefa = userService.findById(id);
        return ResponseEntity.ok(tarefa);
    }

    @PostMapping
    public ResponseEntity<Tarefa> create(@RequestBody Tarefa tarefaToCreate){
        var tarefaCreated = userService.create(tarefaToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tarefaCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(tarefaCreated);
    }
}
