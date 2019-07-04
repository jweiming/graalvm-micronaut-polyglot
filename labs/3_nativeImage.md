# 3. Building Native Image

In this lab you will get familiar with building the Micronaut application and using Docker to build the native image.

## Background

GraalVM Native Image allows you to ahead-of-time compile Java code to a standalone executable, called a native image. This executable includes the application, the libraries, the JDK and does not run on the Java VM, but includes necessary components like memory management and thread scheduling from a different virtual machine, called “Substrate VM”. Substrate VM is the name for the runtime components (like the deoptimizer, garbage collector, thread scheduling etc.). The resulting program has faster startup time and lower runtime memory overhead compared to a Java VM.

For more information you can refer to the official documentations [https://www.graalvm.org/docs/reference-manual/aot-compilation/](https://www.graalvm.org/docs/reference-manual/aot-compilation/)

### 1. Build the fatjar

Let's build the Micronaut application by going to the project directory (i.e. where the ```gradlew``` files are)

```
$ ./gradlew assemble
```
The builds the ```./build/libs/complete-0.1.jar```. As a standlone Micronaut application, you can run the application by using HotSpot JVM.

```
$ java -jar .build/libs/complete-0.1.jar
```

### 2. Create Native Image inside Docker

Once we have the fatjar, we can create the native image inside Docker.

```
$ ./docker-build.sh
```
This process takes some time as it will process all the classes and dependencies of the application, including those from the JDK. It statically analyses these classes to determine which classes and methods are reachable and used during application execution. Then it passes all this reachable code as the input to the GraalVM compiler which ahead-of-time compiles it to the native binary. 

When the docker image is successfully built, it should show up in the list of Docker images locally.

```
$ sudo docker images -a
```

### 3. Running the Application

We can now run the application by running the Docker container.

```
$ sudo docker run complete
```
After the server is started, you can open another terminal and access the service.
```
$ curl localhost:8080/meetup/random 
{"name":"Autonomous Data Warehouse"}

$ curl localhost:8080/abs/java/-99
running abs in Java -> 99

$ curl localhost:8080/abs/ruby/-99
running abs in Ruby -> 99
```
