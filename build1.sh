cd spring-eureka-server && mvn clean install -Dmaven.test.skip=true && cd target/ && java -jar spring-eureka-server-0.0.1-SNAPSHOT.jar
cd spring-eureka-auth && mvn clean install -Dmaven.test.skip=true && cd target/ && java -jar spring-eureka-auth-0.0.1-SNAPSHOT.jar
cd spring-eureka-zuul && mvn clean install -Dmaven.test.skip=true && cd target/ && java -jar spring-eureka-zuul-0.0.1-SNAPSHOT.jar
cd paciente && mvn clean install -Dmaven.test.skip=true && cd target/ && java -jar paciente-0.0.1-SNAPSHOT.jar