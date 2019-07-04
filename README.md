# Developer Meetup on GraalVM
The developer meetup provides an introduction to GraalVM and how it can be used to build simple polyglot applications. You will be going through a technical sharing on GraalVM and participating in a hands-on lab on building your own polyglot application on GraalVM.

The lab exercises used in this meetup is available at [link](link).

## Agenda

- Introduction to GraalVM
- Accessing your development environment (Oracle Cloud Developer Image)
- Installing Micronaut
- Creating a Micronaut application with GraalVM
- Embedding Ruby languange into Java (Polyglot)
- Building the fatjar
- Building the native image

## Accessing Workshop Infrastructure

For the workshop, a cloud compute instance ([Oracle Cloud Developer Image](https://cloudmarketplace.oracle.com/marketplace/en_US/listing/54030984)) is provisioned and you should be able to access it and use it for the duration of the workshop. 

The access pack for the instances (e.g. instance details and SSH keys) are available at [link](link).

## Lab Instructions on GraalVM

Note that once you have downloaded the access pack, you should be able to access your assigned instance with SSH. To verify that the instance is correct, try checking the version of ```Java```as follows.

```
$ ssh -i /path/to/private_key.pem opc@<server_host>

[opc@javaociinstance ~]$ java -version
java version "1.8.0_212"
Java(TM) SE Runtime Environment (build 1.8.0_212-b31)
Java HotSpot(TM) GraalVM EE 19.0.0 (build 25.212-b31-jvmci-19-b01, mixed mode)
```

You should see that GraalVM is already installed on the instance.

## Local Lab Instructions

The various labs are organized into the following sections.

- [1. Creating a Micronaut application](labs/1_micronaut.md)
- [2. Polyglot programming](labs/2_polyglot.md)
- [3. Building the native image](labs/3_nativeImage.md)
- [4. Comparing the performance](labs/4_performance.md)

We recommend you to follow the instructions and create the app step by step. However, you can go right to the completed example by cloning the git repository.

```
$ git clone https://github.com/jweiming/graalvm-micronaut-polyglot
```




