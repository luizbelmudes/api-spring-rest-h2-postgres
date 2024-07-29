package luizbr.service;

import luizbr.domain.model.Tarefa;

public interface UserService {
    Tarefa findById(Long id);

    Tarefa create(Tarefa tarefaToCreate);
}
