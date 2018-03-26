// ------------------------------------------------------------
//  Copyright (c) Microsoft Corporation.  All rights reserved.
//  Licensed under the MIT License (MIT). See License.txt in the repo root for license information.
// ------------------------------------------------------------

package counteractor;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import microsoft.servicefabric.actors.runtime.ActorRuntime;
import microsoft.servicefabric.actors.runtime.FabricActorService;

public class CounterActorHost {

    private static Logger logger = Logger.getLogger(CounterActorHost.class.getName());
    
    public static void main(String[] args) throws Exception {

        try {
            ActorRuntime.registerActorAsync(CounterActorImpl.class, (context, actorType) -> new FabricActorService(context, actorType, (a,b)-> new CounterActorImpl(a,b)), Duration.ofSeconds(10));
            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception in registration: {0}", e.toString());
            throw e;
        }
    }

}
