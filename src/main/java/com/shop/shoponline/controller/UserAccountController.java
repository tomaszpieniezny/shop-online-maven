package com.shop.shoponline.controller;

import com.shop.shoponline.mapper.UserAccountMapper;
import com.shop.shoponline.model.dto.UserAccountDto;
import com.shop.shoponline.model.entity.UserAccount;
import com.shop.shoponline.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class UserAccountController {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping(method = RequestMethod.GET, value = "/userAccount")
    public List<UserAccountDto> getUserAccount() {
        return userAccountMapper.mapToUserAccountDtoList(userAccountService.findAllUserAccount());
    }
    @RequestMapping(method = RequestMethod.GET, value = "/userAccount/{id}")
    public UserAccountDto getUserAccountById(@PathVariable int id) throws Exception {
        return userAccountMapper.mapToUserAccountDto(userAccountService.getUserAccount(id).orElseThrow(Exception::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/userAccount", consumes = APPLICATION_JSON_VALUE)
    public UserAccount createUserAccount(@RequestBody UserAccount newUserAccount) {
        return userAccountService.saveUserAccount(newUserAccount);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/userAccount", consumes = APPLICATION_JSON_VALUE)
    public UserAccount updateUserAccount(@RequestBody UserAccount updateUserAccount) {
        return userAccountService.saveUserAccount(updateUserAccount);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/userAccount/{id]")
    public void deleteUserAccount(@PathVariable int id) {
        userAccountService.deleteUserAccount(id);
    }
}
