package com.trevorism.controller

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.trevorism.https.SecureHttpClient
import com.trevorism.model.DataListContent
import com.trevorism.model.DeployRequest
import com.trevorism.model.RollbackRequest
import com.trevorism.model.ServiceVersionInfo
import com.trevorism.model.WorkflowRequest
import com.trevorism.model.WorkflowResponse
import com.trevorism.secure.Roles
import com.trevorism.secure.Secure
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.inject.Inject

@Controller("/deploy")
class DeployController {

    private final Gson gson = (new GsonBuilder()).setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create()

    @Inject
    SecureHttpClient secureHttpClient

    @Tag(name = "Deploy Operations")
    @Operation(summary = "Lists all deployable services **Secure")
    @Get(value = "/", produces = MediaType.APPLICATION_JSON)
    @Secure(Roles.SYSTEM)
    List<String> list() {
        String response = secureHttpClient.get("https://list.data.trevorism.com/api/6553743902375936/content")
        DataListContent content = gson.fromJson(response, DataListContent)
        return content.data
    }

    @Tag(name = "Deploy Operations")
    @Operation(summary = "Deploys a service **Secure")
    @Post(value = "/", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.SYSTEM, allowInternal = true)
    WorkflowResponse deploy(@Body DeployRequest request) {
        String json = secureHttpClient.post("https://github.project.trevorism.com/repo/${request.serviceName}/workflow", gson.toJson(new WorkflowRequest()))
        gson.fromJson(json, WorkflowResponse)
    }

    @Tag(name = "Deploy Operations")
    @Operation(summary = "Get service available versions **Secure")
    @Get(value = "/{name}", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.SYSTEM, allowInternal = true)
    ServiceVersionInfo getServiceVersionInfo(String name) {

    }

    @Tag(name = "Deploy Operations")
    @Operation(summary = "Rollback to specified version **Secure")
    @Put(value = "/", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.SYSTEM, allowInternal = true)
    RollbackRequest rollback(@Body RollbackRequest rollbackRequest) {

    }
}
