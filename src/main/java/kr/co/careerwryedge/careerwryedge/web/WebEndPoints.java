package kr.co.careerwryedge.careerwryedge.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class WebEndPoints {

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route() // 함수형 엔드포인트를 정의
                .GET("/home-fallback", request ->
                        ServerResponse.ok().body(Mono.just("Hello, World!"), String.class)
                )
                .GET("/member-fallback", request ->
                        ServerResponse.ok().body(Mono.just(""), String.class)
                )
                .POST("/member-fallback", request ->
                        ServerResponse.status(HttpStatus.METHOD_NOT_ALLOWED).build()
                ).build();
    }
}
