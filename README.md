# Api Stock Quote Manager

Application which purpose is to store stock quotes from stock market.

## SWAGGER 

- **Swagger** http://localhost:8080/stock-quote/api/v1/swagger-ui.html#/

## Start with application java
- **Run Java** Inside folder target execute command (`java -jar stock-0.0.1-SNAPSHOT.jar`) or inside in folder main project execute command (`mvn spring-boot:run`) *verify if maven support java 11 (`mvn-version`)*
- **Executar Java** Dentro da pasta target executar o comando (`java -jar stock-0.0.1-SNAPSHOT.jar`) ou dentro da pasta principal do projeto executar o comando (`mvn spring-boot:run`) *verificar se o maven suporta java 11 (`mvn-version`)*

## Start application with docker
- **Run Docker-compose** In terminal or command line execute command in project main folder(**`docker-compose -f docker-compose.yml up -d`**)*

- **Executar Docker-compose** Pelo terminal ou prompt de comando execute o comando na pasta principal do projeto(**`docker-compose -f docker-compose.yml up -d`**)*

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
![image](https://user-images.githubusercontent.com/10129476/113339642-24685600-9301-11eb-9a6f-74d888f3c4f4.png)
![image](https://user-images.githubusercontent.com/10129476/113339683-3c3fda00-9301-11eb-9776-daf075f4036e.png)
![image](https://user-images.githubusercontent.com/10129476/113339703-4530ab80-9301-11eb-886f-f57523fad504.png)



##### **Note: Database Mysql run together project in command docker-compose / Banco de dados iniciará junto com a aplicação no comando docker-compose**
###### Note: Necessary Java 11 / Necessário java 11
