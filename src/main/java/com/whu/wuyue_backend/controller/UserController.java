package com.whu.wuyue_backend.controller;

import com.whu.wuyue_backend.entity.UserRegisterEntity;
import com.whu.wuyue_backend.mapper.UserMapper;
import com.whu.wuyue_backend.model.User;
import com.whu.wuyue_backend.service.UserService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController{
    private final UserMapper userMapper;
    private UserService userService;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/user/register")
    public ResponseEntity<String> register(@RequestBody UserRegisterEntity request) {
        System.out.println(request.getUsername());

        if (request.getUsername() == null || request.getUsername().isEmpty() ||
                request.getPassword() == null || request.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body("用户名或密码不能为空");
        }

        // 调用服务层的注册方法
        int result = userService.userRegister(request.getUsername(), request.getPassword());
        if (result == -1) {
            return ResponseEntity.status(409).body("用户名已存在");
        }

        return ResponseEntity.ok("注册成功");
    }

    @GetMapping("/user/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        // 检查用户名和密码是否为空
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return ResponseEntity.badRequest().body("用户名或密码不能为空");
        }

        // 调用服务层的登录方法
        User user = userService.userLogin(username, password);
        if (user == null) {
            System.out.println("登录失败~");
            return ResponseEntity.status(401).body("Invalid username or password");
        }

        // 返回成功的响应，包含token
        return ResponseEntity.ok(new LoginResponse(user.getId(), username));
    }

    // 登录响应封装类
    @Getter
    public static class LoginResponse {
        private Integer userId;
        private String username;

        public LoginResponse(Integer userId, String username) {
            this.userId = userId;
            this.username = username;
        }

    }
}
