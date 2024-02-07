package com.magic4.magicard.mk.controller;

import com.magic4.magicard.mk.dto.EmployeeEmailDto;
import com.magic4.magicard.mk.dto.EmployeeInfoDto;
import com.magic4.magicard.mk.dto.LoginRequestDto;
import com.magic4.magicard.mk.service.AuthService;
import com.magic4.magicard.mk.service.EmployeeService;
import com.magic4.magicard.vo.Employee;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final EmployeeService employeeService;
    private final AuthService authService;

//    @PostMapping("/login")
//    public ResponseEntity<EmployeeInfoDto> login(HttpServletRequest httpServletRequest, LoginRequestDto loginRequestDto){
//
//        HttpSession session=httpServletRequest.getSession();
//
//        aut
//    }
}
