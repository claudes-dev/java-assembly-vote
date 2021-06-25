# java-assembly-vote

## Para o rodar o projeto

<h1>Para rodar a API Java</h1>

- [x] JDK na Versão 8
- [x] Spring Tools Suite 4 ou qualquer outra IDE de Java
- [x] Postgres instalado
- [x] Maven instalado
- [x] Lombok instalado na IDE

### Variáveis de ambiente para login no banco de dados

* JDBC_DATABASE_URL
* JDBC_DATABASE_PASSWORD
* JDBC_DATABASE_USERNAME

#### Para testar o projeto no swagger ao rodar o mesmo
#### utilize o seguinte context-path: java-assembly-vote/swagger-ui.html
#### por exemplo https://java-assembly-vote.herokuapp.com/java-assembly-vote/swagger-ui.html

## Objetivo

#### No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias, por votação.

#### A partir disso, você precisa criar uma solução back-end para gerenciar essas sessões de votação.

#### Essa solução deve ser executada na nuvem e promover as seguintes funcionalidades através de uma API REST:

* Cadastrar uma nova pauta
* Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo
determinado na chamada de abertura ou 1 minuto por default);
* Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado é
identificado por um id único e pode votar apenas uma vez por pauta);
* Contabilizar os votos e dar o resultado da votação na pauta.

#### Para fins de exercício, a segurança das interfaces pode ser abstraída e qualquer chamada para as interfaces
pode ser considerada como autorizada. A escolha da linguagem, frameworks e bibliotecas é livre (desde que
não infrinja direitos de uso).
