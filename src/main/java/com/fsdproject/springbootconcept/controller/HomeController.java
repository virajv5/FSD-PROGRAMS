package com.fsdproject.springbootconcept.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

      @GetMapping("/normal")
        public ResponseEntity<String> normalUser(){
            return ResponseEntity.ok("Yes i am normal user");
        }

        @GetMapping("/admin")
        public ResponseEntity<String> adminUser(){
          return ResponseEntity.ok("Yes i am a admin user");
        }

}
