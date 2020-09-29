/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bamdule.controller;

import com.bamdule.model.UserVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bamdule.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/signUp")
    public ResponseEntity signUp(@RequestBody UserVO userVO) {
        System.out.println("[MYTEST] " + userVO);
        userService.saveUser(userVO);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(userService.selectUsers());
    }

}
