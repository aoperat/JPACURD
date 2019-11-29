# JPACURD

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
  
  