package fandor

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.event.S3EventNotification
import io.micronaut.function.FunctionBean
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.function.Consumer
import com.amazonaws.regions.Regions
import com.amazonaws.services.sns.AmazonSNSClientBuilder
import com.amazonaws.services.sns.model.PublishRequest
import java.io.InputStream


//import AWS from 'aws-sdk'

@FunctionBean("reach-engine-event-handler")
class ReachEngineEventHandlerFunction : Consumer< S3EventNotification>,S3FileRepo,SNSTopicGateway {

    val LOG: Logger = LoggerFactory.getLogger(ReachEngineEventHandlerFunction::class.java)

    override fun accept(event: S3EventNotification) {

        println("event: ${event}")
        val lastRecord = event.records.last() // have to get a record from the records list
        val textEventOutput = getRequest(lastRecord)
        postRequest(textEventOutput)

//        println("bucket name: ${lastRecord}")
//        LOG.debug("bucket name: ${lastRecord}")
//        println("s3: ${lastRecord.s3}")
//        LOG.debug("s3: ${lastRecord.s3}")
//        println("bucket name: ${lastRecord.s3.bucket.name}")
//        LOG.debug("bucket name: ${lastRecord.s3.bucket.name}")
//        val s3bucketlink = "https://s3.amazonaws.com/" + lastRecord.s3.bucket.name +"/" +lastRecord.s3.`object`.key
//        println("link: ${s3bucketlink}")
//
//        val s3Client: AmazonS3 = AmazonS3ClientBuilder.standard()
//                .withRegion(lastRecord.awsRegion)
//                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
//                .build()
//        val payloadObject = s3Client.getObject(lastRecord.s3.bucket.name, lastRecord.s3.`object`.key)
//        println("payloadObject: ${payloadObject}")
//        println("object content: ")
//        val message = transformInputStreamToText(payloadObject.objectContent)
//
//        val snsClient = AmazonSNSClientBuilder.standard().withRegion(Regions.US_EAST_1).build()
//
//        val topicArn = "arn:aws:sns:us-east-1:862208614941:update-film"
//        val publishRequest = PublishRequest(topicArn, message)
//        val publishResult = snsClient.publish(publishRequest)
//        //print MessageId of message published to SNS topic
//        println("MessageId - " + publishResult.getMessageId())

    }

}

fun transformInputStreamToText(input: InputStream):String {
    // Read the text input stream one line at a time and display each line.
    val inputAsString = input.bufferedReader().use { it.readText() }
    return inputAsString
}

interface S3FileRepo{
    fun getRequest(lastRecord:S3EventNotification.S3EventNotificationRecord):String{
        val LOG: Logger = LoggerFactory.getLogger(ReachEngineEventHandlerFunction::class.java)
        val s3bucketlink = "https://s3.amazonaws.com/" + lastRecord.s3.bucket.name +"/" +lastRecord.s3.`object`.key
        LOG.debug("link: ${s3bucketlink}")

        val s3Client: AmazonS3 = AmazonS3ClientBuilder.standard()
                .withRegion(lastRecord.awsRegion)
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                .build()
        val payloadObject = s3Client.getObject(lastRecord.s3.bucket.name, lastRecord.s3.`object`.key)
         return transformInputStreamToText(payloadObject.objectContent)

    }
}

interface SNSTopicGateway{
    fun postRequest(message:String){
        val LOG: Logger = LoggerFactory.getLogger(ReachEngineEventHandlerFunction::class.java)
        val snsClient = AmazonSNSClientBuilder.standard().withRegion(Regions.US_EAST_1).build()

        val topicArn = "arn:aws:sns:us-east-1:862208614941:update-film"
        val publishRequest = PublishRequest(topicArn, message)
        val publishResult = snsClient.publish(publishRequest)
        //print MessageId of message published to SNS topic
        LOG.debug("MessageId - " + publishResult.getMessageId())
    }
}
