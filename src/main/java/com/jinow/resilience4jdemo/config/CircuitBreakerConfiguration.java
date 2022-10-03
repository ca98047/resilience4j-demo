package com.jinow.resilience4jdemo.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.core.registry.EntryAddedEvent;
import io.github.resilience4j.core.registry.EntryRemovedEvent;
import io.github.resilience4j.core.registry.EntryReplacedEvent;
import io.github.resilience4j.core.registry.RegistryEventConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class CircuitBreakerConfiguration {

    @Bean
    public RegistryEventConsumer<CircuitBreaker> mpayCircuitBreakerRegistryEventConsumer() {

        return new RegistryEventConsumer<CircuitBreaker>() {
            @Override
            public void onEntryAddedEvent(EntryAddedEvent<CircuitBreaker> entryAddedEvent) {
                String circuitBreakerName = entryAddedEvent.getAddedEntry().getName();
                entryAddedEvent.getAddedEntry().getEventPublisher().onStateTransition(event -> {
                    CircuitBreaker.StateTransition stateTransition = event.getStateTransition();
                    String msg = circuitBreakerName + " : " + stateTransition.getFromState() + " -> " + stateTransition.getToState();
                    log.warn("CircuitBreaker onEntryAddedEvent : {}", msg);
                });
            }

            @Override
            public void onEntryRemovedEvent(EntryRemovedEvent<CircuitBreaker> entryRemoveEvent) {
                entryRemoveEvent.getRemovedEntry().getEventPublisher().onEvent(event -> log.info(event.toString()));
                String circuitBreakerName = entryRemoveEvent.getRemovedEntry().getName();
                entryRemoveEvent.getRemovedEntry().getEventPublisher().onStateTransition(event -> {
                    CircuitBreaker.StateTransition stateTransition = event.getStateTransition();
                    String msg = circuitBreakerName + " : " + stateTransition.getFromState() + " -> " + stateTransition.getToState();
                    log.warn("CircuitBreaker onEntryRemovedEvent : {}", msg);
                });
            }

            @Override
            public void onEntryReplacedEvent(EntryReplacedEvent<CircuitBreaker> entryReplacedEvent) {
                entryReplacedEvent.getNewEntry().getEventPublisher().onEvent(event -> log.info(event.toString()));
                String circuitBreakerName = entryReplacedEvent.getNewEntry().getName();
                entryReplacedEvent.getNewEntry().getEventPublisher().onStateTransition(event -> {
                    CircuitBreaker.StateTransition stateTransition = event.getStateTransition();
                    String msg = circuitBreakerName + " : " + stateTransition.getFromState() + " -> " + stateTransition.getToState();
                    log.warn("CircuitBreaker onEntryReplacedEvent : {}", msg);
                });
            }
        };
    }
}
