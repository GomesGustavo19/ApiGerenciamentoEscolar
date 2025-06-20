ApiGerenciamentoEscolar

Atores e suas Funções

Diretor

  Funções:

    Acessar relatórios gerais sobre o progresso dos alunos.

    Consultar estatísticas sobre desempenho de turmas e professores.

    Configurar e atualizar o calendário escolar.

    Definir regras do sistema, como pesos de avaliações.

Secretário

  Funções:

    Cadastrar e gerenciar professores.

    Cadastrar e gerenciar alunos.

    Vincular alunos e professores às matérias.

    Cadastrar e gerenciar matérias.

Professor

  Funções:
  
    Registrar notas dos alunos.

    Registrar faltas.

    Cadastrar a descrição da aula do dia.

Aluno

  Funções:

    Consultar suas notas e matérias vinculadas.

Endpoints 

Diretor

    GET /diretores/relatorios: Consultar relatórios gerais.

    GET /diretores/estatisticas: Consultar estatísticas de turmas e professores.

    PUT /diretores/calendario: Atualizar calendário escolar.

    PUT /diretores/regras: Configurar regras do sistema.

Secretário

    POST seretaria/teacher: Cadastrar professores.

    GET seretaria/teacher: Pesquisar professores.

    PUT seretaria/teacher: Atualizar Professores
    
    DELETE seretaria/teacher: Deletar Professores

    POST seretaria/student: Cadastrar alunos.

    GET seretaria/student: Pesquisar alunos.
    
    PUT seretaria/student: Atualizar alunos.
    
    POST seretaria/matter: Cadastrar matérias.

    PUT secretaria/matter: Atualizar Matter

    POST seretaria/class: Vincular classroom, student.

Professor

    POST /professores/notas: Cadastrar notas.

    POST /professores/faltas: Cadastrar faltas.

    POST /professores/aulas: Cadastrar descrição da aula.

Aluno

    GET /alunos/notas: Consultar notas.

    GET /alunos/materias: Consultar matérias vinculadas.

Autenticação

    POST auth/login: Autenticar usuário.

    GET auth/register: Retornar informações do usuário autenticado.