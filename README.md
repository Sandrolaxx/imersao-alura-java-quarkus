## 😎 Sobre o projeto

Trata-se de uma aplicação criada com os conhecimentos adquiridos na [Imersão Alura Java☕](https://github.com/Sandrolaxx/imersao-alura-java), é uma API em Quarkus criada para ser consumida pela aplicação front-end [Geradora de Stikers](https://github.com/Sandrolaxx/imersao-alura-next) criado com base nos ensinamentos da [Imersão Alura React/Next.js⚛️](https://github.com/alura-challenges/aluraquiz-base). Ambas as Imersões foram de extrema importância em minha caminhada como Dev, a primeira foi muito interessante para relembrar como é programar Java sem nenhuma lib ou framework e também para convidar meus amigos a terem seu primeiro contato com a linguagem, já a segunda me apresentando conceitos basilares do framework Next.js que utilizo atualmente em todos os meus novos projetos.

[Quarkus](), the Supersonic Subatomic Java Framework

---

## 🤓 Tecnologias utilizadas

* 🔤 Lang - [JAVA](https://www.java.com/pt-BR/)
* ⚛️ Framework - [Quarkus](https://quarkus.io/)
* ✅ Test - [JUnit5](https://junit.org/junit5/)
* ✅ Test - [Approval Tests](https://approvaltests.com/)

---

## 🧑‍💻 Como iniciar a aplicação

### Executando o aplicativo no dev mode

Você pode executar em dev mode utilizando os seguinte comando:
```script de shell
./mvnw quarkus:dev
```

> **_NOTE:_** Quarkus vem com uma Dev UI disponível em dev mode em http://localhost:8080/q/dev/.

### Empacotando e executando a aplicação

A aplicação pode ser empacotada usando:
```script de shell
./mvnw package
```
O comando produz o arquivo `quarkus-run.jar` no diretório `target/quarkus-app/`.

Esteja ciente de que não é um _über-jar_ pois as dependências são copiadas para o diretório `target/quarkus-app/lib/`.

A aplicação pode ser executada com o comando: 
```bash
java -jar target/quarkus-app/quarkus-run.jar
```

Se você deseja construir um _über-jar_, execute o seguinte comando:
```bash
./mvnw package -Dquarkus.package.type=uber-jar
```

A aplicação empacotada como um _über-jar_ pode ser executada com: 
```bash
java -jar target/*-runner.jar
```

---

## 📃 Licença

Este projeto está sobre a licença [MIT](LICENSE).