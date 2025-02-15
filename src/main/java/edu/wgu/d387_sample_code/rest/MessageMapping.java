package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.D387SampleCodeApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(path ="/eTime", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String easternTime() {
        String firstTime = D387SampleCodeApplication.timeEastern.toString();
        return firstTime;
    }
    @RequestMapping(path ="/mTime", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String mountainTime() {
        String secondTime = D387SampleCodeApplication.timeMountain.toString();
        return secondTime;
    }
    @RequestMapping(path ="/utcTime", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String utcTime() {
        String thirdTime = D387SampleCodeApplication.timeUTC.toString();
        return thirdTime;
    }
}
