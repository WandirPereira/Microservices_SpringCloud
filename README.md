# Microservices_SpringCloud
Microservice com Spring Cloud, Eureka, Spring Boot, KeyCloak e RabbitMQ

***CRIANDO CONTAINERS PARA CADA SERVIÇO:***

  * Criando a rede: 
    * docker network create ac-network
  
  * Container banco de dados:
    * docker run --name mysql_ac -d -p 3306:3306 -v /c/mysql_datadir:/var/lib/mysql --network ac-network -e MYSQL_ROOT_PASSWORD=12345 mysql:latest

  * Container Rabbitmq:
    *  docker run --hostname rabbitmq_ac --name rabbitmq_ac -p 5672:5672 -p 15672:15672 -e RABBITMQ_DEFAULT_USER=guest -e RABBITMQ_DEFAULT_PASS=guest   --network ac-network rabbitmq:3.10-management
    * Configurar fila emissao-cartoes
  
  * Container KeyCloak:
    * docker run --name keycloak_ac -p 8084:8080 --network ac-network -e KEYCLOAK_ADMIN_PASSWORD=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:18.0.0 start-dev
    
  * Container eurekaserver:
    * docker build --tag wandir/eureka_ac .
    * docker run --name eureka_ac -p 8761:8761 --network ac-network wandir/eureka_ac
    
  * Container mscloudgateway:
    * docker build  --build-arg  EUREKA_SERVER=eureka_ac  --build-arg KEYCLOAK_SERVER=keycloak_ac --tag wandir/mscloudgateway .
    * docker run --name mscloudgateway_ac --network ac-network -d wandir/mscloudgateway  
  
  * Container msclientes:
    * docker build --build-arg EUREKA_SERVER=eureka_ac  --build-arg MYSQL_SERVER=mysql_ac --tag wandir/msclientes_ac .
    * docker run --name msclientes_ac --network ac-network -d wandir/msclientes_ac   

  * Container mscartoes:
    * docker build --build-arg EUREKA_SERVER=eureka_ac  --build-arg MYSQL_SERVER=mysql_ac --build-arg RABBITMQ_SERVER=rabbitmq_ac --tag wandir/mscartoes_ac .
    * docker run --name mscartoes_ac --network ac-network -d wandir/mscartoes_ac 

  * Container msavaliadorcredito:
    * docker build --build-arg EUREKA_SERVER=eureka_ac --build-arg RABBITMQ_SERVER=rabbitmq_ac --tag wandir/msavaliadorcredito_ac .
    * docker run --name msavaliadorcredito_ac --network ac-network -d wandir/msavaliadorcredito_ac    
  

