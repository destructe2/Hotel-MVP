package edu.wgu.d387_sample_code.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static edu.wgu.d387_sample_code.D387SampleCodeApplication.thread1;
import static edu.wgu.d387_sample_code.D387SampleCodeApplication.thread2;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MessageMapping {
    @RequestMapping(path ="/english", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String englishMessage() {
        String finalMessage = thread1;
        return finalMessage;
    }
    @RequestMapping(path ="/french", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String frenchMessage() {
        String otherMessage = thread2;
        return otherMessage;
    }
}
