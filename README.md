<h2 align="center">
  <p align="center"> CHALLENGE ONE HOTEL ALURA </p>
  </h2>
Este proyecto es un sistema de reservas para un hotel, el cual está escrito en el lenguaje Java usando la Biblioteca Java Swing en el diseño y Maven como herramienta para gestión de dependencias.
Asi tambien la Base datos se desarrollo en MySQL accediendo mediante JDBC.

<h6 align="center">
<img src="https://github.com/jackcn123/challenge-one-alura-hotel/blob/master/CapturaBusqueda.PNG">
  </h6>

El sistema permite lo siguiente:

- Sistema de autenticación de usuario para que solo usuarios pertenecientes al hotel consigan acceder al sistema.
- Permitir crear, editar y eliminar una reserva para los huéspedes.
- Registrar, editar y eliminar datos de los huéspedes.
- Buscar en la base de datos todas las informaciones tanto de los clientes como de las reservas.
- Calcular automaticamente el valor de la reserva en base a la cantidades de días y a una tasa diaria, este valor será mostrado al usuario antes de guardar la reserva.
- Base de datos para almacenar todos los datos pedidos anteriormente.

## Uso

Para usar el sistema ingresaremos en el "Menu Principal" y luego en Login. Esta ventana permite ingresar su usuario y contraseña para acceder al sistema. 
Utilizaremos los siguientes datos:
* usuario predeterminado: admin
* contraseña: admin

Para el "Registro de Reservas" simplemente escogeremos la **fecha de ingreso** y **fecha de salida** para que el sistema pueda calcular automaticamente el **valor de la reserva** e indicaremos la **forma de pago**.

Por ejemplo si tenemos una reserva de 3 dias y el valor de nuestra tasa diaria es S/. 80.00 debemos multiplicar esos 3 dias por el valor de la diaria, lo que serian S/. 180.00, todo esto deberá ser hecho automaticamente y mostrado al usuario antes de guardar la reserva. 

El siguiente paso será ingresar los datos del huesped. Al culminar se mostrará al usuario un mensaje de "*Datos guardados satisfactoriamente*" y se indicará el **numero de reserva**.

Para la sección de "Búsqueda", permite al usuario buscar las informaciones que están dentro de nuestra base de datos.
Existen dos criterios de búsqueda:
- Apellido.
- Número de Reserva.
Estos datos serán presentado a través de dos tablas.

Al seleccionar cualquier registro el usuario podrá, editar o eliminar dicho registro.

<h6 align="center">
<img src="https://github.com/jackcn123/challenge-one-alura-hotel/blob/master/CapturaExito.PNG">
  </h6>

## Extras
- Se han considerado los posibles errores que puedan suceder:
		Dejar campos vacíos antes de registrar una reserva o datos del huésped.
		Colocar una fecha de ingreso posterior al de salida.
- Se ha colocado una carpeta con la DB correspondiente en MySQL
		La misma se encuentra en la carpeta DB

<h6 align="center">
<img src="https://github.com/jackcn123/challenge-one-alura-hotel/blob/master/CapturaError.PNG">
  </h6>

## Requisitos

- Java 8 o superior
