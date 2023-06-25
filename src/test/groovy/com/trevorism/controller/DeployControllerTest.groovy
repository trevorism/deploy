package com.trevorism.controller

import com.trevorism.https.AppClientSecureHttpClient
import com.trevorism.model.DeployRequest
import org.junit.jupiter.api.Test

class DeployControllerTest {

    @Test
    void testServiceList(){
        DeployController dc = new DeployController()
        //dc.secureHttpClient = new AppClientSecureHttpClient()
        //println dc.deploy(new DeployRequest(serviceName: "chat"))
        assert dc
    }

}
