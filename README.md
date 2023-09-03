<h1 align="center">
  <p align="center"> CHALLENGE ONE HOTEL ALURA </p>
  </h1>
Este proyecto es un sistema de reservas para un hotel, el cual está escrito en el lenguaje Java usando la Biblioteca Java Swing en el diseño y Maven como herramienta para gestión de dependencias.
Asi tambien la Base datos se desarrollo en MySQL accediendo mediante JDBC.

El sistema permite consta de lo siguiente:

- Sistema de autenticación de usuario para que solo usuarios pertenecientes al hotel consigan acceder al sistema.
- Permitir crear, editar y eliminar una reserva para los clientes.
- Buscar en la base de datos todas las informaciones tanto de los clientes como de las reservas.
- Registrar, editar y eliminar datos de los huéspedes.
- Calcular automaticamente el valor de la reserva en base a la cantidades de días y a una tasa diaria, este valor será mostrado al usuario antes de guardar la reserva.
- Base de datos para almacenar todos los datos pedidos anteriormente.

Tenemos a disposición un Diagrama de Entidad Relación usado en el diseño de nuestra base de Datos.

## Uso

Para usar el sistema, en el "Registro de Reservas" simplemente escogeremos la fecha de ingreso y fecha de salida para que el sistema pueda calcular automaticamente el valor de la reserva.
Por ejemplo si tenemos una reserva de 3 dias y el valor de nuestra tasa diaria son 20$ debemos multiplicar esos 3 dias por el valor de la diaria, lo que serian 60$, todo esto deberá ser hecho automaticamente y mostrado al usuario antes de guardar la reserva;

## Extras

+ 

## Requisitos

- Java 8 o superior
