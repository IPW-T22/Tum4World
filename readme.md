## Requisiti
- Apache Tomcat `8.5.87`
- Open JDK `1.8.0_382`
- Apache Derby `10.14.2.0`

## Istruzioni per il deploy
### Creazione DB
- `java -jar %DERBY_HOME%/lib/derbyrun.jar server start`
- `java -jar %DERBY_HOME%/lib/derbyrun.jar ij`<br>
Versione ij 10.16<br>
ij> `CONNECT 'jdbc:derby://localhost:1527/tum4world;create=true';`<br>
ij> `exit;`
### Deploy webserver
- Eseguire la task Maven `Build "tum4world:war exploded" artifact` con application context  `/tum4world`
- Avviare il server Tomcat con gli artefatti appena compilati
### Testing
- Visitare la pagina http://localhost:8080/tum4world/