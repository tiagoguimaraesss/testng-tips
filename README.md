# TestNG Tips
Projeto com intuito de mostrar na prática algumas dicas e práticas relacionadas ao _framework_ de teste **TestNG**.

## Objetivo
Explorar na prática as funcionalidades que o _framework_ de teste **TestNG** entrega para os seus usuários.

## Tecnologias Utilizadas
- [**AssertJ**](https://assertj.github.io/doc/), como biblioteca de asserções customizadas :white_check_mark:
- [**Java**](https://openjdk.java.net/), como linguagem de programação :coffee:
- [**Lombok**](https://projectlombok.org/), como biblioteca para trabalhar com POJO :wrench:
- [**Maven**](https://maven.apache.org/), como gerenciador de dependências :wrench:
- [**Rest Assured**](https://rest-assured.io/), como _framework_ para teste de _webservice_ :white_check_mark:
- [**TestNG**](https://testng.org/doc/), como _framework_ de teste :white_check_mark:

## Sistema Alvo de Testes
Para realizar as experimentações com o **TestNG**, foi escolhido um _webservice_ para ser testado. Neste contexto,
o sistema seleciona foi o [**ViaCEP**](https://viacep.com.br/). O **ViaCEP**, é um _webservice_ que dispõe de basicamente
duas funcionalidades:

- Consulta de endereço postal por CEP
- Consulta de CEP por logradouro + estado