# Jotace Forum.

Esse projeto inteiro foi feito com o intuito, de, aprender sobre clean architecture.
É um projeto pessoal feito do zero e eu depositei muito carinho e esforço nele.
## 🚀 Começando

Para conseguir uma cópia do projeto somente será necessário clicar em code e download zip.

### 📋 Pré-requisitos

```
JDK 17 Instalada.
```
```
MySQL com um banco de dados criado com o nome de: clean-code123,
```
```
IDE de preferencia IntelliJ
```

### 🔧 Instalação
O sistema não utiliza nenhum micro-serviço complexo até então.
A instalação se baseia somente em instalar a Ide(InteliJ) e rodar o código.
(A própria ide resolve o resto para você.
## Como usar

### Controllers
A aplicação contem um usuário que contem, foto de perfil, nome, email, senha e posts.
Foi construida com o intuito de que um usuário tenha vários posts e vários posts tenham somente um usuário.

O controller do usuário faz o crud básico permitindo, deletar, atualizar, criar e selecionar. Porém, esses
metodos só podem ser utilzados após a autenticação via Token JWT, que foi implantada de acordo com, meu 
entendimento do que é o clean architecture.

A aplicação contem também uma entidade de posts, que contem um titulo, descrição, imagem e categória.

Categória sendo um enum que contem: front-end, back-end, mobile e games(Até então).

Para a utilização da API é recomendado utilizar o insominia para fazer as requisições, já que, quando é feito
uma requisição pelo swagger(Biblioteca de documentação dinamica. Falarei mais sobre abaixo) o código apresenta
alguns bugs de autenticação que eu ainda não resolvi.

Portanto, toda via, a documentação da api pode ser consultada pelo swagger acessando o link: http://localhost:8080/swagger-ui/index.html#
(lembrando que para utilizar a documentação, é necessário rodar a API).

A documentação acima, apresenta exemplos de como realizar todas as requisições da api, com exemplos, descrições(Ainda não completa para todas as requisições) e até mesmo consultas reais na api, porém o swagger parece não conseguir fazer autenticação(Vou procurar uma resolução para isso), o que impede de se utilzar o endpoint de login, e por isso é extremamente necessário usar o insominia.

## Futuras melhorias

Enquanto eu fazia esse código eu aprendi bastante, era pra ser somente um código de treino, porém eu me esforcei muito para escrever esse código.
Em respeito a quantidade de aprendizado que esse código me proporcionou, eu decidi melhorar esse código o maximo que eu puder.
Seguem abaixo as futuras melhorias.

### 1.0 Problema das imagens (Atualmente feito).

Vou começar do que eu suponho que seja o mais fácil.
Por mais que o código fale que o usuário tem uma imagem de perfil, por enquanto este usuário, somente
recebe um parametro de string para receber uma url como imagem, logo, não é o metodo mais agradavel para usabilidade.

De acordo com o problema, eu decidi que o próximo passo vai ser, adicionar suporte para imagens via multipart-form, algo que
eu ainda não sei fazer, e estou bem animado para fazer acontecer.

Essa funcionalidade atualmente foi implementada(Não irei apagar, para ser possível acompanhar a evolução das ideias do projeto).

### 2.0 Comentários(Em progresso)

No momento da criação da entidade de post, eu percebi que, por mais que não estivesse nos meus planos(Nada estava na verdade),
séria muito interessante uma feature onde, séria póssivel adicionar comentários em cada post, parecido com a relação de usuário,
para posts, onde um usuário tem vários posts, porém um post tería vários comentarios(legal né?).

### 3.0 Curtidas

Seguindo a mesma lógica dos comentários, porque não adicionar curtidas? deixaria mais parecido com um forum ou uma rede social,
para programadores.

### 4.0 Filtro

Agora algo mais interessante ainda.
No dia a dia, quando utilzamos um forum ou uma rede social, é obvio que queremos ver algo do nosso interesse né?
Como um post tem uma categoria, porque não fazer uma paginação dinamica, de acordo com o que o usuário curtir?,
seria algo como selecionar quantas curtidas você deu em determinada categoria e fazer co que ela aparessa mais do que as outras.

Pense no número 6, suponha que temos 3 categorias assim :

categoriaX: 200 curtidas,
categoriaY: 150 curtidas,
categoriaZ: 100 curtidas

A ideia é, a categoriaX vai aparecer 3 vezes a cada 6(restando 3),
a categoriaY vai aparecer 2 vezes a cada 6(restando 1)
e por fim a categoriaZ vai aparecer 1 vez a cada 6.

sendo assim: a cada 6 posts, 3 vãos ser de x, 2 vão ser de y e 1 vai ser sobre z.

Estou realmente animado para fazer isso.

### Login por google

Pra ajudar no dinamismo do login, seria bem legal utilizar o login via conta do google, algo que sinceramente,
quando um site não tem, eu sei que várias pessoas até desistem de usar, não é mesmo?

### Por fim o Front

Estou estudando um pouco de angular nos bastidores, e espero fazer um front-end a altura para esse backend, já que,
eu me diverti muito e aprendi muito enquanto escrevia ele.

Quem sabe um dia não possa ser algo que vá ser utilzado por alguém ❤️.

# Explicação do código.
O código foi separado em camadas, sendo elas, core, application, infra e main(Explicação de cada uma abaixo).

## Camada core
É a camada que determina como a aplicação deverá funcionar em todos os aspectos.

### Boundary
É a camada de casos de uso da minha aplicação, ela determina o contrato que deve ser seguido, para realizar cada funcionalidade
da aplicação.

### Entity
É a camada de entidade, que define como uma entidade deve se comportar e seus atributos.

### Exception
É a camada das exceções que podem ocorrer na aplicação(serão tratadas nas camadas acima).

### Model 
É a camada que define as requsições e as respostas do usuário.

## Camada Application
É a camada que carrega a lógica de negocios da aplicação e cria uma ponte entre o código externo e as abstrações.

### UseCases
É a camada que implementa os boundarys e realiza a lógica de negocio da aplicação(Ainda sem nenhum código externo).

### Presenter
É a camada responsavel por devolver as respostas de sucesso, ou de falha.

### Gateway
É a camada que faz a ligação do código externo e o código java atráves de abstrações.
Essa camada é responsável por prover funcionalidades a camada de usecases. Exemplo:
A camada que vai encontrar um usuário pelo id, deletar, criar e etc.
A camada de usecases utiliza essas funções e faz a lógica.

## Camada infra
Camada com o código externo, que finalmente utiliza de códigos de frameworks, como o Spring e o Hibernate.

### Impl
A camada que implementa as abstrações do gateway, ela vai implementar o gateway e realizar o código
necessário de acordo com as regras do contrato. Lembrando que, essa camada somente depende das abstrações,
não interessa se o código esta sendo feito pelo hibernate ou por outro framework por exemplo, o código vai realizar a mesma função,
isso garante a escalabilidade do código, já que, caso necessário possa ser alterado o framework.

### Persistence
A camada de persistencia, é a camada que vai se relacionar com o banco de dados, camada responsável por, administrar as tabelas,
e as querys com o banco de dados.

### Mapper
Camada que mapeia os usuários, passa um usuário de persistencia para um usuário definido pela camada core de entidades e vice-versa.

### Controller
Camada que recebe as requisições e utiliza dos interactors para fazer o código funcionar.

## Main
Camada de configurações e serviços externos necessários para o funcionamento do código.

### Config
Onde são definidas as Beans do código, que definem como cada abstração deve se portar, por exemplo,
quando chamar o gateway do usuário na camada application, eu quero que a função esteja sendo realizada pela implementação na camada infra.

### Exception
Onde ficam os tratamentos de todas as exceções que podem ser jogadas no código. Camada responsável por capturar exceções e devolver uma resposta apropriada.

### Service
Onde ficam os services necessários para que funcionalidades externas funcionem.

## 🛠️ Construído com

* [Spring Boot](https://spring.io/projects/spring-boot;) - O framework web usado
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [JWT](https://jwt.io/) - Autenticação via token.


## ✒️ Autores

* **João Carlos Machado Filho** - *Trabalho Inteiro* - [João Carlos](https://github.com/joao31245)

## 📄 Licença
Sob Open Software License v3.0.
---
Espero que gostem!, tudo que eu programo é feito com amor.
⌨️ com ❤️ por [João Carlos](https://github.com/joao31245) 😊
