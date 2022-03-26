package dev.bumbler.springreactiverestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class StudentRouter {

    private StudentService studentService;

    @Autowired
    public StudentRouter(StudentService studentService) {
        this.studentService = studentService;
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/v1/api/async/students", serverRequest -> {
                    return studentService.getAsyncStudents();
                })
                .build();
    }
}
