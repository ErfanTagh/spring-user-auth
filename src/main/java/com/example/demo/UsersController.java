package com.example.demo;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UsersController {

    private final UsersRepository repository;

    UsersController(UsersRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/users")
    List<Users> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/users")
    Users newUser(@RequestBody Users newUser) {
        return repository.save(newUser);
    }

    // Single item

    @PostMapping("/auchuser")
    EmailResponse check(@RequestBody Users user) {
        Users findedUser = repository.findByEmail(user.getEmail());
        if(findedUser==null){

            return new EmailResponse(0);
        }
         if(repository.findByEmail(user.getEmail()).getPass().equals(user.getPass())){
        return new EmailResponse(1);}

        return new EmailResponse(2);

    }

    @GetMapping("/users/{id}")
    Users one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new UsersNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    Users replaceUser(@RequestBody Users newUser, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setPass(newUser.getPass());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}