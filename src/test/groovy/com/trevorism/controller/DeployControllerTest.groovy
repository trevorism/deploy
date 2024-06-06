package com.trevorism.controller

import com.trevorism.https.SecureHttpClient
import com.trevorism.model.DeployRequest
import org.junit.jupiter.api.Test

class DeployControllerTest {

    @Test
    void testList() {
        DeployController deployController = new DeployController()
        deployController.secureHttpClient = [get: { url -> '{data: ["one","two"]}' }] as SecureHttpClient
        def result = deployController.list()
        assert result
        assert result.contains("one")
        assert result.contains("two")
    }

    @Test
    void testDeploy() {
        DeployController deployController = new DeployController()
        deployController.secureHttpClient = [post: { url, x -> '{statusUrl: "test"}' }] as SecureHttpClient
        def result = deployController.deploy(new DeployRequest(serviceName: "test"))
        assert result
        assert result.serviceName == "test"
    }
}
