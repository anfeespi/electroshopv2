Este es nuestro repositorio para la versión final de la api del Taller #1 del corte #2 de Ingenieria de Software 2

#API

El primer paso es descargar y toda la carpeta de electroshopv2 importarla por medio de Eclipse IDE, siguiendo los pasos de File > Import > Projects From Folder or Archive
El aplicativo trabaja sobre Java 17, lo cual significa que de tener un JDK superior al 17 deberia funcionar perfectamente, en caso contrario recomendamos descargar el Java Development Kit 17 de su página oficial

#Base de datos
Dentro del repositorio también hay un script de MySQL que se debe ejecutar antes del aplicativo, en nuestro caso usamos MySQL Workbench y recomendamos los siguientes pasos:
  
  1- Descargar MySQL Server y crear un servidor para el aplicativo
  
  2- (IMPORTANTE) Por buenas prácticas el aplicativo no se conecta al usuario root de la base de datos por lo que *recomendamos crear un nuevo usuario con permisos DBA de nombre "api" y contraseña "ingenieriadesoftware2"*
 
  3- Descargar MySQL Workbench para manejar la base de datos, en este caso el paso anterior se puede facilitar desde este aplicativo
 
  4- Ejecutar el script en MySQL Workbench (Bien sea en el usuario root o el usuario api)

- Andrés Espitia
- Kevin Peña
- Johan Gomez
- David López
