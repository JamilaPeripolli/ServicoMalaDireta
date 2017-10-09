# ServicoMalaDireta
Esse projeto é um exemplo de uma aplicação REST utilizando Spring Boot. 
O serviço de mala direta pode receber um POST no endpoint "/maladireta" com um array (em JSON) de alunos,
então verificar em APIs mockadas se estes alunos possuem notas vermelhas, 
por fim enviar emails aos alunos que possuem notas vermelhas.

O JSON enviado para o endpoint "/maladireta" deve estar no formato:
[
  {
    "nome" : "Jose da Silva",
    "endereco" : "Rua Silvio Santos, 55",
    "cep" : "99999-999",
    "mensagem" : "Texto referente a mensagem para o aluno"
  },
...
]

O projeto está configurado para subir a aplicação na porta 8080.
