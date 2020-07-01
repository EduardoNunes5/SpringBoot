package com.lab01.psoft.services;


import com.lab01.psoft.models.Subject;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class SocialNetworkService{

    private Map<Integer, Subject> subjects = new HashMap<>();

    public Subject save(String name, double grade){
        int key = generateKey();
        if(!this.subjects.containsKey(key)) {
            Subject subject = new Subject(key, name, grade);
            this.subjects.put(key, subject);
            return subject;
        }
        return this.save(name, grade);
    }
    public List<Subject> getAllSubjects(){
        return new ArrayList<>(this.subjects.values());
    }
    public Subject findById(Integer id){
        return this.subjects.get(id);
    }
    public Subject setName(Integer id, String name){
        Subject subject = this.findById(id);
        if(subject != null)
            subject.setName(name);
        return subject;
    }

    public Subject setGrade(Integer id, Double grade){
        Subject subject = this.subjects.get(id);
        subject.setGrade(grade);
        return subject;
    }

    public Subject deleteSubject(Integer id){
        return this.subjects.remove(id);
    }

    private Integer generateKey(){
        Random rand = new Random();
        Integer number = rand.nextInt();
        if(number < 0){
            return generateKey();
        }
        return number;
    }
}
