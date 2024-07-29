package luizbr.service.impl;

import luizbr.domain.model.Tarefa;
import luizbr.domain.repository.TarefaRepository;
import luizbr.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final TarefaRepository tarefaRepository;

    public UserServiceImpl(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public Tarefa findById(Long id) {
        return tarefaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Tarefa create(Tarefa tarefaToCreate) {
        if (tarefaToCreate != null && tarefaRepository.existsById(tarefaToCreate.getId())){
            throw new IllegalArgumentException("Esta tarefa já está cadastrada");
        } else if (tarefaToCreate == null){
            return null;
        }
        return tarefaRepository.save(tarefaToCreate);
    }
}
