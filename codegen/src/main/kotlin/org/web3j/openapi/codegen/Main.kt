/*
 * Copyright 2020 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.web3j.openapi.codegen

import org.web3j.openapi.codegen.config.ContractConfiguration
import org.web3j.openapi.codegen.config.ContractDetails
import org.web3j.openapi.codegen.config.GeneratorConfiguration
import org.web3j.openapi.codegen.web3jCodegenStuff.SolidityFunctionWrapperGenerator
import java.io.File

fun main() {

    val solidityFunctionWrapper = SolidityFunctionWrapperGenerator(
        abiFile = File("/home/chamirachid/tmp/openapi/AbiTst/something.abi"),
        basePackageName = "com.app",
        destinationDir = File("/home/chamirachid/tmp/openapi/AbiTst/"))

    val configuration = GeneratorConfiguration(
        "testApp",
        "com.app.test",
        "/home/chamirachid/tmp/openapi/ClientTest",
        listOf(
            ContractConfiguration(
                File("/home/chamirachid/tmp/openapi/AbiTst/something.abi"),
                ContractDetails(
                    "Something",
                    solidityFunctionWrapper.loadContractDefinition(File("/home/chamirachid/tmp/openapi/AbiTst/something.abi"))
                )
            ),
            ContractConfiguration(
                File("/home/chamirachid/tmp/openapi/AbiTst/something.abi"),
                ContractDetails(
                    "Somehow",
                    solidityFunctionWrapper.loadContractDefinition(File("/home/chamirachid/tmp/openapi/AbiTst/something.abi"))
                )
            )
        )
    )
    val generator = GenerateOpenApi(configuration)
            generator.generateAll()

//    val functionsDefinition = solidityFunctionWrapper.loadContractDefinition(File("/home/chamirachid/tmp/openapi/AbiTst/something.abi"))
    println()
}
