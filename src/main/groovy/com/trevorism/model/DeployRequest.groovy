package com.trevorism.model

class DeployRequest {

    String serviceName
    String destinationPlatform
    String destinationProject
    String destinationEnvironment
    String version
    Map<String,String> configuration
    List<String> secrets
}
