# Mental Login
Cas için Rest servis sağlar.

# Dependency
- Mental Authentication - Authentication Dbsine ihtiyaç duymaktadır.
- Mental User - Kullanıcı adından kullanıcı idsini getirmelidir.
- Postgresql - Authentication Dbsi

### Run postgresql before login
<code>docker run --name cont_postgresql 
-itd -p 5432:5432 --restart always 
-e DB_NAME=authentication-dev,authentication-qa 
-e DB_USER=dbuser -e DB_PASS=12345 sameersbn/postgresql</code>

### Run authentication before login
<code>docker run -itd --name cont_authentication -p 10020:10020 
--link cont_postgresql mental/authentication</code>

# Build
Gradle build işlemi için

<code>gradlew build</code>

# Run

#### Gradle üzerinden run etmek için

<code>gradlew bootRun</code> or

<code>gradlew bRun</code>

###### Environment
İstediğiniz environment için komutun sonuna -Dspring.profiles.active={profile-name} ekleyin.

Örneğin

<code>gradlew bootRun -Dspring.profiles.active=qa</code>


#### Java üzerinden run etmek için

<code>java -jar build/libs/login.jar</code>

###### Environment
İstediğiniz environment için komutun sonuna --spring.profiles.active={profile-name} ekleyin.

Örneğin

<code>java -jar build/libs/login.jar --spring.profiles.active=qa</code>


# Docker

## Projeyi docker komutundan çalıştırma
>Docker run ile çalıştırırken dependent olan containerları ayağa kaldırmalısınız.

<code>docker run -it --name cont_login -p 10000:10000 --link cont_postgresql mental/login</code>

# Docker compose dan çalıştırma
> Compose ile çalıştırırken dependent olan başka containerlar var ise durdurunuz. Yoksa port çakışması olur.

<code>docker-compose up</code>


## Up yaparken build etmek için
<code>docker-compose up --build</code>


## Build docker
> Imagei değiştirmek isterseniz.

Projeyi gradle ile build ettikten sonra docker 
imageini oluşturmak için docker build etmelisiniz.

<code>docker build -t mental/login .</code>


# Browse

[http://localhost:10000/login](http://localhost:10000/login)








