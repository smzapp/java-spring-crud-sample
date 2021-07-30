# Guide

By Samuel

# First hello world
1. start.spring.io
2. Dependencies
- jpa
- web spring
- h2database
3. For intellij, if resources and project files don't exist, refresh maven.


# FAQs
1. Removing and installing of dependency
- Go to `pom.xml`
- then, add or remove dependency
- refresh maven `https://i.imgur.com/TrFo4oV.png`

2. `spring-boot-maven-plugin:2.5.3:run` ERROR
- https://i.imgur.com/Hf7bIuh.png
- Possible solution, check application.properties

````
spring.datasource.url=jdbc:mysql://localhost:3307/hibernate_exerdb
spring.datasource.username=root
spring.datasource.password=test
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.database-platform = org.hibernate.dialect.MySQL5Dialect
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto = update
````