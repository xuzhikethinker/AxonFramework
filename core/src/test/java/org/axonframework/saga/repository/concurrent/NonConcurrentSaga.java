/*
 * Copyright (c) 2010-2012. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.saga.repository.concurrent;

import org.axonframework.saga.annotation.EndSaga;
import org.axonframework.saga.annotation.SagaEventHandler;
import org.axonframework.saga.annotation.StartSaga;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Allard Buijze
 */
public class NonConcurrentSaga extends AbstractTestSaga {

    private static final long serialVersionUID = 5329800443421589068L;
    private List<Object> events = new ArrayList<Object>();

    @StartSaga
    @SagaEventHandler(associationProperty = "id")
    public void handleCreated(CreateEvent event) {
        this.events.add(event);
    }

    @SagaEventHandler(associationProperty = "id")
    public void handleUpdate(UpdateEvent event) {
        this.events.add(event);
    }

    @EndSaga
    @SagaEventHandler(associationProperty = "id")
    public void handleDelete(DeleteEvent event) {
        this.events.add(event);
    }

    @Override
    public List<Object> getEvents() {
        return events;
    }
}
