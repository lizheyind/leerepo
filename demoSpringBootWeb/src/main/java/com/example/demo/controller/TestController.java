package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CertMapper;

@RestController
public class TestController {
	
	@Resource
	CertMapper cm;
	
	@GetMapping("/listcert")
	public List listUser() {
		return cm.listCert();
	}
}
