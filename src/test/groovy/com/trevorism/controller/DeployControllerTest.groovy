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
    void testListReadsTheDataStandardSurface() {
        String requested = null
        DeployController deployController = new DeployController()
        deployController.secureHttpClient = [get: { url -> requested = url; '{data: ["one"]}' }] as SecureHttpClient

        deployController.list()

        assert requested == "https://list.data.trevorism.com/object/6553743902375936/content"
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
