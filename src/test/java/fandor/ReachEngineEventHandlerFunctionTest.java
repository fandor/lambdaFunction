package fandor;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReachEngineEventHandlerFunctionTest {

    @Test
    public void testFunction() throws Exception {
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class);

        ReachEngineEventHandlerClient client = server.getApplicationContext().getBean(ReachEngineEventHandlerClient.class);

        assertEquals(client.index().blockingGet(), "reach-engine-event-handler");
        server.stop();
    }
}
