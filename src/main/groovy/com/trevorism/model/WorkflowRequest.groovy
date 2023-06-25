package com.trevorism.model

class WorkflowRequest {
    String branchName = "master"
    String yamlName = "deploy.yml"
    Map<String, String> workflowInputs = [:]
}
