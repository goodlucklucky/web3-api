Web3j API
==============

[![Build Status](https://travis-ci.org/web3j/web3j-api.svg?branch=master)](https://travis-ci.org/web3j/web3j-api)

Web3j-API is a [API](https://swagger.io/specification/) client and server generator from 
[Solidity](https://solidity.readthedocs.io/) smart contracts. it provides a way to interact with the Ethereum blockchain via simple and intuitive 
HTTP requests, abstracting the coding layer. These interactions can be done using :
- Plain HTTP requests
- Via the `Swagger-UI`, which is generated with every project
- A client application using the [`webj3-api-client`](/client) implementation

The workflow can be summed in the following steps:
- Writing a Solidity smart contract
- Generating the corresponding **API** project using **Web3j-API**
- Running the generated project as a standalone server
- Sending HTTP requests using `Swagger-UI`, client application or `Curl` request.

# Getting started with Web3j-API
To generate an API project using the [Web3j-API](https://github.com/hyperledger/web3j-api) generator, 
you need to have the [Web3j-CLI](https://docs.web3j.io/latest/command_line_tools/) installed on your machine. 
It’s easy to do (for Windows instructions head [here](https://github.com/hyperledger/web3j-cli/)):
	
```ssh
$ curl -L get.web3j.io | sh
```

### Create a Hello World project
To create a base API project using a `Hello World` contract, run the following :

```ssh
$ web3j api new
```

You can also generate a `Web3j-API` project using the [Web3j-API-gradle-plugin](https://github.com/web3j/web3j-api-gradle-plugin).

### Configure the project
After having the generated project, you can configure your application with the following environment variables:

```ssh
$ export WEB3J_ENDPOINT=<link_to_your_Ethereum_node>
$ export WEB3J_PRIVATE_KEY=<your_private_key>
$ export WEB3J_OPENAPI_HOST=localhost
$ export WEB3J_OPENAPI_PORT=9090
```

### Run the project
If you aren't using the Web3j-CLI you may run the project using the following Gradle target:

```ssh
$ cd <project_folder>
$ ./gradlew run
```

Then, you should be seeing the server logs.

### Interact with the project

#### SwaggerUI
The easiest way to interact with the generated project is via the generated `Swagger-UI` which can be found on `http://<host>:<port>/swagger-ui`.

![image](https://github.com/web3j/web3j-docs/blob/master/docs/img/Web3j-API/SwaggerUI_1.png)

#### Web3j-API client
Also, you can use our client implementation via adding the following dependency to your project:
```groovy
dependencies {
    implementation "org.web3j.api:web3j-api-client:4.12.2"
}
```

Then, within the application:

```kotlin
val service = ClientService("http://localhost:9090")
val app = ClientFactory.create(<AppNameApi>::class.java, service)

// Then you have access to all the API resources
val receipt = app.contracts.contractName.deploy()

println("Deployment receipt: ${receipt.contractAddress}")

// ...
```

#### **For more information**, please refer to the [documentation](https://docs.web3j.io/web3j_api).
