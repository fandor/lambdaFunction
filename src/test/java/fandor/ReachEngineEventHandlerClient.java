package fandor;

import io.micronaut.function.client.FunctionClient;
import io.reactivex.Single;

import javax.inject.Named;

@FunctionClient
public interface ReachEngineEventHandlerClient {

    @Named("reach-engine-event-handler")
    Single<String> index();

}
