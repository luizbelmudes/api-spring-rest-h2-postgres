# API - Cadastro de Tarefas (TO DO List)
A API desenvolvida permite o cadastro de Tarefas, contendo o horario do dia que a terefa deve ser cumprida, o nível de prioridade, o dia da semana, e a atividade em si. A ideia de criar uma atividade como uma classe/tabela paralela é permitir que atividades repetidas possam apenas ser referenciadas, sem a necessidade de duplicar informações. Da mesma forma, cada atividade terá categorias específicas, e separando estas categorias em uma classe/tabela a parte, podemos ter diferentes atividades de mesma categoria, sem duplicação dos dados.

## Exemplo de Payload
Segue abaixo um exemplo de payload JSON para uso no Swagger:

```
{
  "id": 1,
  "horario": "20:30",
  "prioridade": "0",
  "diaDaSemana": "Segunda-Feira",
  "atividade": {
    "id": 1,
    "descricao": "Treinar Guitarra",
    "categoria": {
      "id": 1,
      "descricaoCategoria": "hobby"
    }
  }
}
```
## UML criada com auxílo do ChatGPT


```mermaid
classDiagram
    class Atividade {
        +Long id
        +String descricao
        +Categoria categoria
    }

    class Categoria {
        +Long id
        +String descricaoCategoria
    }

    class Tarefa {
        +Long id
        +String horario
        +String prioridade
        +String diaDaSemana
        +Atividade atividade
    }

    Atividade "N" *-- "1" Categoria
    Tarefa "N" *-- "1" Atividade
```