package com.nevalabs.reactive.config;

import com.nevalabs.reactive.handlers.RouterHandlers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class ReactiveConfig {

    @Bean
    RouterFunction<?> routerFunction(RouterHandlers routerHandlers) {
        return RouterFunctions.route(RequestPredicates.GET("/employee/all"), routerHandlers::getAll)
                .andRoute(RequestPredicates.GET("/employee/{id}"), routerHandlers::getId)
                .andRoute(RequestPredicates.GET("/employee/{id}/events"), routerHandlers::getEvents);
    }
}
