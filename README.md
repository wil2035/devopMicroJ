## Installation (local)
* Clone this repository:
```shell
$ git clone https://github.com/<your-username>/devops-.git
$ cd devops-
```

* Install the packages with maven:
```shell
$ mvn clean package

```
* Build and run docker
```shell
$ docker build -t microjava:v1 .
$ docker run --name microjava -d -p 8081:6000 microjava:v1
```


* Run the app locally
```shell
mvn spring-boot:run
```
