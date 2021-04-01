# Api Stock Quote Manager

Application which purpose is to store stock quotes from stock market.

## SWAGGER 

- **Swagger** http://localhost:8080/stock-quote/api/v1/swagger-ui.html#/

## Start with application java
- **Run Java** Inside folder target execute command (`java -jar stock-0.0.1-SNAPSHOT.jar`) or inside in folder main project execute command (`mvn spring-boot:run`) *verify if maven support java 11 (`mvn-version`)*
- **Executar Java** Dentro da pasta target executar o comando (`java -jar stock-0.0.1-SNAPSHOT.jar`) ou dentro da pasta principal do projeto executar o comando (`mvn spring-boot:run`) *verificar se o maven suporta java 11 (`mvn-version`)*

## Start application with docker
- **Run Docker** In terminal or command line execute command (**`docker container run -p 8080:8080 -d fernandoleis/stock-manager:v2`**)*

- **Executar Docker** Pelo terminal ou prompt de comando execute o comando (**`docker container run -p 8080:8080 -d fernandoleis/stock-manager:v2`**)*

- **MySql Database** In terminal or command line execute command (**`docker container run -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=bootdb -p 3306:3306 -p 33060:33060 -d mysql:8`**)*

- **MySql Banco de dados** Pelo terminal ou prompt de comando execute o comando (**`docker container run -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=bootdb -p 3306:3306 -p 33060:33060 -d mysql:8`**)*

**INCLUDING JSON OF APIS FOR IMPORT IN POSTMAN (Stock.postman_collection.json) - MAIN FOLDER**

**INCLUÍDO O JSON DAS CHAMADAS APIS PARA IMPORT NO POSTMAN (Stock.postman_collection.json) - PASTA PRINCIPAL**

## CURL

- `curl --location --request POST 'http://localhost:8080/stock-quote/api/v1/stock' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": "petr3",
    "quotes": {
        "2019-01-01": "10",
        "2019-01-02": "11",
        "2019-01-03": "14"
    }
}'`

- `curl --location --request GET 'http://localhost:8080/stock-quote/api/v1/stock'`

- `curl --location --request GET 'http://localhost:8080/stock-quote/api/v1/stock/PETR3'`

- `curl --location --request DELETE 'http://localhost:8080/stock-quote/api/v1/stock/PETR3'`

## Images / Imagens 

###### Note: Necessary Java 11 / Necessário java 11