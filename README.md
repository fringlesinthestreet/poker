# Poker API

* Autor: Benjamín Cárcamo

## Funcionamiento de la API

Se generó un endpoint:
> /newgame?players=N

Donde se le pasa un número N de jugadores y este retorna el ganador.

La única restricción es que N es un número natural entre 1 y 10.

Esta aplicación ya se encuentra desplegada en:
> https://limitless-wave-05458.herokuapp.com/v1/newgame?players=1

## Compilación

Para compilar el código se debe utilizar el siguiente comando dentro del directorio del proyecto:
> ./mvnw package

Esto genera el jar para ser desplegado:
>./target/pokerGauss-0.0.1-SNAPSHOT.jar

