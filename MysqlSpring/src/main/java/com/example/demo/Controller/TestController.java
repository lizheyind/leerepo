package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
  
import javax.annotation.Resource;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
  
import com.example.demo.dao.CertMapper;
  
@RestController
public class TestController {
 @Resource
 CertMapper cm;
   
 @GetMapping("/list")
 public List listCert() {
  return cm.listCert();
//	 ArrayList<String> test= new ArrayList<String>();
//	 test.add("had");
//	 test.add("trouble");
//	 return test;
 }
 
 @GetMapping("/testCert")
 public String testCert() {
	 return "certs here";
 }
}