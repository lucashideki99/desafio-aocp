Durante a execução do desafio foi utilizado o ChatGPT, ele foi utilizado como auxílio para estruturação e desenvolvimento do sistema.

Segue alguns exemplos de como foi utilizado:

> "conta Id, nome_titular, numero_conta, saldo, status, data_criacao numero_conta deve ser único; saldo não pode iniciar negativo movimentacao Id, conta_origem_id, conta_destino_id, valor, tipo, data_hora, observacao Relacionar contas de origem e destino crie o script de criação de tabelas para essas requisições"

> Segue um script SQL (PostgreSQL) atendendo suas regras:

```sql
-- Tabela Conta
CREATE TABLE conta (
   id SERIAL PRIMARY KEY,
   nome_titular VARCHAR(150) NOT NULL,
   numero_conta VARCHAR(20) NOT NULL UNIQUE,
   saldo NUMERIC(15,2) NOT NULL CHECK (saldo >= 0),
   status VARCHAR(20) NOT NULL,
   data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Tabela Movimentação
CREATE TABLE movimentacao (
   id SERIAL PRIMARY KEY,
   conta_origem_id INT,
   conta_destino_id INT,
   valor NUMERIC(15,2) NOT NULL CHECK (valor > 0),
   tipo VARCHAR(20) NOT NULL,
   data_hora TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   observacao TEXT,

   CONSTRAINT fk_conta_origem
       FOREIGN KEY (conta_origem_id)
       REFERENCES conta(id),

   CONSTRAINT fk_conta_destino
       FOREIGN KEY (conta_destino_id)
       REFERENCES conta(id)
);

````
No trecho anterior que a saída foi gerada com o auxílio do ChatGPT, sendo posteriormente realizados ajustes manuais, como a alteração do tipo da coluna numero_conta na tabela conta

---

>em um contexto de aplicação java web com jsp, a aplicaçao é um controle financeiro que faz as seguintes fuccionalidades, gerenciamento de conta, transferencia e histórico de transferencia, faça um menu front, jsp index.jsp para essa aplicação

>Aqui está um exemplo simples e funcional de um index.jsp com menu front-end (estilo dashboard) para sua aplicação de controle financeiro (contas, transferências e histórico).

>Vou usar HTML + Bootstrap (CDN) para deixar o layout mais bonito e pronto para evoluir com Servlets/JSP.

```
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Controle Financeiro</title>

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f4f6f9;
        }

        .navbar {
            margin-bottom: 30px;
        }

        .card-menu {
            transition: 0.2s;
        }

        .card-menu:hover {
            transform: scale(1.03);
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
        }

        .container-main {
            margin-top: 50px;
        }
    </style>
</head>

<body>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">💰 Finance Control</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="menu">
            <ul class="navbar-nav ms-auto">

                <li class="nav-item">
                    <a class="nav-link" href="contaServlet?action=listar">Contas</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="transferenciaServlet?action=novo">Transferência</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="transferenciaServlet?action=historico">Histórico</a>
                </li>

            </ul>
        </div>
    </div>
</nav>
```

Também fiz alguns ajustes na tela, como por exemplo a criação de header e footer separado que é chamado por todas as telas para padronização.


O uso do ChatGPT foi realizado ao longo de todo o processo de desenvolvimento do desafio, sendo utilizado tanto para a geração de códigos base quanto para auxiliar na correção de problemas e esclarecimento de dúvidas.

Os códigos gerados por IA foram analisados por mim e ajustados sempre que necessário, visando melhorar a estrutura do sistema, a legibilidade e a compreensão do código.