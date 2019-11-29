# JPACURD

사용자 생성 및 권한주기 
DB 생성

GRANT ALL PRIVILEGES ON *.* TO cos@localhost;

create user 'ssar'@'%' identified by 'bitc5600';
grant all privileges on *.* to 'ssar'@'%';
create database ssar;
use ssar;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdData` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(30) NOT NULL,
  `role` varchar(255) DEFAULT 'user',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `board` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `createDate` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FKnwfsptg8pbhl5hnphivfydtpy` (`userId`),
  CONSTRAINT `FKnwfsptg8pbhl5hnphivfydtpy` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

  




yml
```
server:
  port: 8080
  servlet:
    context-path: /

spring:
  mvc: 
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp

  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/ssar?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true
    username: ssar
    password: bitc5600
   
  jpa:
    open-in-view: false
    hibernate:
      ddl-auto: update
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
      use-new-id-generator-mappings: false
    show-sql: true
    properties:
      hibernate.enable_lazy_load_no_trans: true
      hibernate.format_sql: true

  http:
    encoding:
      charset: UTF-8
      enabled: true
      force: true
      
  servlet:
    multipart:
      enabled: true
      max-file-size: 1MB
        
file:
  path: C:\dev\tools\sts-4.4.1.RELEASE\workspace\JPA-CRUD\src\main\resources\upload\
  ```
  

  
