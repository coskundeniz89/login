FROM mental/jre
ADD build/libs/login.jar /app/login.jar
EXPOSE 10000
CMD java -jar /app/login.jar --connection=cont_postgresql