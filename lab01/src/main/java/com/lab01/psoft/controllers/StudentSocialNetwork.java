package com.lab01.psoft.controllers;


import com.lab01.psoft.models.EmptySubject;
import com.lab01.psoft.models.Subject;
import com.lab01.psoft.services.SocialNetworkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class StudentSocialNetwork {

    SocialNetworkService socialNetworkService;

    public StudentSocialNetwork(SocialNetworkService sns){
        super();
        this.socialNetworkService = sns;
    }

    @PostMapping("/v1/api/disciplinas")
    public ResponseEntity<Subject> postSubject(@RequestParam(name="name", required=true) String name, @RequestParam(name="grade", required=true) double grade){
        return new ResponseEntity<>(socialNetworkService.save(name, grade), OK);
    }

   @GetMapping("/v1/api/disciplinas")
    public ResponseEntity<List<Subject>> getDisciplinas(){
        return new ResponseEntity<List<Subject>>(this.socialNetworkService.getAllSubjects(), OK);
    }

    @GetMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<Subject> getSubject(@PathVariable(required = false) Integer id){
        Subject subject = this.socialNetworkService.findById(id);
        if(subject != null){
            return new ResponseEntity<>(subject, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new EmptySubject(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/v1/api/disciplinas/{id}/nome")
    public ResponseEntity<Subject> setName(@PathVariable(required=true) Integer id, @RequestBody Map<String, String> body){
        Subject subject = this.socialNetworkService.setName(id, body.get("name"));
        ResponseEntity<Subject> response;
        if( subject != null)
            response = new ResponseEntity<>(subject, HttpStatus.OK);
        else{
            response = new ResponseEntity<>(null, NOT_FOUND);
        }
        return response;
    }

    @PutMapping("/v1/api/disciplinas/{id}/nota")
    public ResponseEntity<Subject> setNota(@PathVariable(required=true) Integer id, @RequestBody Map<String, Double> body) {
        Subject subject = this.socialNetworkService.setGrade(id, body.get("grade"));
        ResponseEntity<Subject> response;
        if (subject != null)
            response = new ResponseEntity<>(subject, HttpStatus.OK);
        else {
            response = new ResponseEntity<>(null, NOT_FOUND);
        }
        return response;
    }

    @DeleteMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<Subject> deleteSubjet(@PathVariable(required=true) Integer id){
        Subject subject = this.socialNetworkService.deleteSubject(id);
        ResponseEntity<Subject> response;
        if(subject != null){
            response = new ResponseEntity<>(subject, HttpStatus.OK);
        }
        else{
            response = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return response;
    }

}
