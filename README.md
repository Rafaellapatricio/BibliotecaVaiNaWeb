# Biblioteca_VaiNaWeb

Repositório destinado a desafio **Salve os Livros** da t2 em Java, do Vai na Web.

**`Realizado por Rafaella Patrício e Vanessa Trajano`**

A Aplicação permite cadastrar, editar, excluir os Livros da Bibioteca. como também cadastrar, editar e excluir Membros da Biblioteca e a por sua vez realizar consulta e empréstimo dos Livros.

## UML do Projeto
<img alt="uml do projeto" src="https://i.imgur.com/AqYKQeY.png">

## Estrutura do Projeto

O projeto está organizado da seguinte forma:
   
**`Biblioteca.java`**: Ponto de entrada do programa. 

    -   Contém a lógica principal para interação com o usuário.
    
    -   Métodos: exibirMenu, adicionarLivro, listarLivro, verificarSituacao, removerLivro.
    
**`Livro.java`**:  Classe extendida da classe `FichaCatalografica.java` com as informações dos Livros.

    -   Atributos: dataEntrada, codigo.    
    -   Métodos: Construtores.

**`FichaCatalografica.java`**: Classe responsável pela Ficha Catalográfica dos Livros.  

    -   Atributos: titulo, autor, localPublic, dataPublic, genero.
    -   Métodos: construtores.
    
**`OperacoesLivro.java`**: Classe responsável por realizar as principais operações relacionadas aos Livros.    

    -   Atributos: List<Livro> listaLivro.    
    -   Métodos: adicionarLivro, listarLivro, verificarSituacao, excluirLivro, alugarLivro.
    
**`OperacoesMembro.java`**: Classe responsável por realizar as principais operações relacionadas aos Membros.    

    -   Atributos: List<Membro> listaMembro.    
    -   Métodos: adicionarMembro, listarMembro, verificarMembro.
    
**`Membro.java`**: Classe extendida da classe `Pessoa.java` com as informações dos membros da Biblioteca.    

    -   Atributos: codigo  
    -   Métodos: Construtores.
    
**`Pessoa.java`**: Classe responsável por conter as informações básicas.    

    -   Atributos:nome, cpf, rg, email, telefone, endereco.     
    -   Métodos: Construtores, visualizar.
    
**`Endereco.java`**: Classe responsável por ...    

    -   Atributos: 
    -   Métodos: Construtores.

## Funcionalidades

1.  **Cadastro de Livro:**    
    -   Utiliza a classe `Livro` e `Operacoes` para criar e armazenar informações referentes aos Livros.

2.  **Consulta de Informações sobre os Livros da Biblioteca:**
    -   Utiliza as classes `Operacoes` e `Livros`para visualizar as informações.
    -   Permite visualizar as informações dos Livros.

3.  **Edição de Informações dos Livros:**
    -   Utiliza as classes `Biblioteca`, `Operacoes` e `Livros` para editar as informações sobres os livros.
    -   Permite Editar as informações dos livros.

4.  **Exclusão de Livros:**
     -   Utiliza as classes `Biblioteca`, `Operacoes` e `Livros` para editar as informações sobres os livros.
    -   Permite Excluir os livros.

5.  **Consulta e Empréstimo de Livros:**
    -   Utiliza as classes `Biblioteca`, `Operacoes`,`Membro` e `Livros` para verificar a disponibilidade dos livros.
    -   Utiliza as classes `Biblioteca`, `Operacoes`,`Membro` e `Livros` para alugar os livros.
    
6.  **Cadastro de Membro:**    
    -   Utiliza a classe `Membro` para criar e armazenar informações referentes aos Membros da Biblioteca.

7.  **Consulta de Informações sobre os Membros da Biblioteca:**
    -   Utiliza a classe `Membro`para visualizar as informações.
    -   Permite visualizar as informações dos Membros.

8.  **Edição de Informações dos Membros:**
    -   Utiliza as classes `Biblioteca` e `Membro` para editar as informações sobres os Membros.
    -   Permite Editar as informações dos Membros.

9.  **Exclusão de Membros:**
     -   Utiliza as classes `Biblioteca`, `Membro` para editar as informações sobres os Membros.
    -   Permite Excluir os Membros.
