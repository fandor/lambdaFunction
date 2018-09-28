package fandor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Lfandor/ReachEngineEventHandlerFunction;", "Ljava/util/function/Consumer;", "Lcom/amazonaws/services/s3/event/S3EventNotification;", "()V", "LOG", "Lorg/slf4j/Logger;", "getLOG", "()Lorg/slf4j/Logger;", "accept", "", "message", "getTextFromStream", "", "input", "Ljava/io/InputStream;", "reachEngineEventHandler"})
@io.micronaut.function.FunctionBean(value = "reach-engine-event-handler")
public final class ReachEngineEventHandlerFunction implements java.util.function.Consumer<com.amazonaws.services.s3.event.S3EventNotification> {
    @org.jetbrains.annotations.NotNull()
    private final org.slf4j.Logger LOG = null;
    
    @org.jetbrains.annotations.NotNull()
    public final org.slf4j.Logger getLOG() {
        return null;
    }
    
    @java.lang.Override()
    public void accept(@org.jetbrains.annotations.NotNull()
    com.amazonaws.services.s3.event.S3EventNotification message) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTextFromStream(@org.jetbrains.annotations.NotNull()
    java.io.InputStream input) {
        return null;
    }
    
    public ReachEngineEventHandlerFunction() {
        super();
    }
}