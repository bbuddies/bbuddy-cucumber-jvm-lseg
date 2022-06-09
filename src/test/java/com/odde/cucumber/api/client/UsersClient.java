package com.odde.cucumber.api.client;

import com.odde.cucumber.api.dto.User;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "usersClient", url = "${api.url}")
public interface UsersClient {

    @PostMapping("/users/signup")
    void signUp(User user);

    @PostMapping("/login")
    Response signIn(User user);
}
