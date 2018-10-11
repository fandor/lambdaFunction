package fandor

import fandor.ReachEngineEventHandlerFunction
import com.amazonaws.services.s3.event.S3EventNotification
import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import junit.framework.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import java.io.ByteArrayInputStream

object ReachEngineEventHandlerFunctionTest: Spek({
    describe("BookController Suite") {
        var embeddedServer : EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        var client : HttpClient = HttpClient.create(embeddedServer.url)

        it("test /hello responds Hello World") {
            val entity:S3EventNotification.RequestParametersEntity = S3EventNotification.RequestParametersEntity( "70.90.214.57" )
            val elements:S3EventNotification.ResponseElementsEntity = S3EventNotification.ResponseElementsEntity("915BAA865A1F12D1","QNnAHIOJAOUq25d9ah/95ZHHh8T4KGNhRXA+UMTXFMBoe1FnTCatCFg0obm9wLPbdxlm6tnSDdI=")
            val id:S3EventNotification.UserIdentityEntity =  S3EventNotification.UserIdentityEntity("7")

            val notification:S3EventNotification.S3BucketEntity = S3EventNotification.S3BucketEntity("owner identity",id,"arn")
            val objectEntity:S3EventNotification.S3ObjectEntity = S3EventNotification.S3ObjectEntity("",7,"","")
            val s3Entity:S3EventNotification.S3Entity = S3EventNotification.S3Entity("PutEvent",notification,objectEntity,"s3schemaVersion")

            val record: S3EventNotification.S3EventNotificationRecord = S3EventNotification.S3EventNotificationRecord("US East (N. Virginia)","ObjectCreated:Put","aws:s3","2018-09-24T21:15:10.404Z","2.0", entity,elements,s3Entity,id)
            val records :List<S3EventNotification.S3EventNotificationRecord>  = mutableListOf(record,record)

            val not:S3EventNotification = S3EventNotification(records)

            val obj:ReachEngineEventHandlerFunction = ReachEngineEventHandlerFunction()

            //obj.accept(not)

            //var rsp : String = client.toBlocking().retrieve("/hello")
            //assertEquals(rsp, "Hello World")
        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
    describe(" test I/O stream converter "){
        it("test I/O Stream Test "){
            val stream = ByteArrayInputStream("Hello there!".toByteArray())
            val  output = transformInputStreamToText(stream)
            assertEquals(output, "Hello there!")
        }
    }
})