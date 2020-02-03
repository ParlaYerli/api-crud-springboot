package com.example.demo.Controller;
import com.example.demo.Service.PersonDao;
import com.example.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    PersonDao personDao;

    @PostMapping("/add")
    public Person createPerson(@Valid @RequestBody Person person){
        return personDao.save(person);
    }

    @GetMapping("/allperson")
    public List<Person> getAllPerson(){
        return personDao.findAll();
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable(value = "id") int id) {
         return personDao.findOne(id);

    }
}
