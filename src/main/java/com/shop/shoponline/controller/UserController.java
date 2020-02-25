package com.shop.shoponline.controller;

import com.shop.shoponline.mapper.UserMapper;
import com.shop.shoponline.model.dao.UserDao;
import com.shop.shoponline.model.dto.UserDto;
import com.shop.shoponline.model.entity.User;
import com.shop.shoponline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserDto> getUser() {
        return userMapper.mapToUserDtoList(userService.findAllUsers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public UserDto getUserById(@PathVariable int id) throws Exception {
        return userMapper.mapToUserDto(userService.getUser(id).orElseThrow(Exception::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users", consumes = APPLICATION_JSON_VALUE)
    public User createUser (@RequestBody User newUser) {
        return userService.saveUser(newUser);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users", consumes = APPLICATION_JSON_VALUE)
    public User updateUser (@RequestBody User updateUser) {
        return userService.saveUser(updateUser);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
