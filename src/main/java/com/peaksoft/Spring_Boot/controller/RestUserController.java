package com.peaksoft.Spring_Boot.controller;

import com.peaksoft.Spring_Boot.message.Response;
import com.peaksoft.Spring_Boot.model.User;
import com.peaksoft.Spring_Boot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class RestUserController {

    public final UserService userService;

    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAll(){
        try{
            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getById(@PathVariable("id") Long userId){
        try{
            return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<User> addUser (@RequestBody User user){
        try{
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<User> updateUser (@RequestBody User user){
        try{
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser (@PathVariable("userId") Long userId){
        try{
            userService.deleteById(userId);
            return new ResponseEntity (HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


//    List<User> user = new ArrayList<>();
//
//    @GetMapping(value = "/all")
//    public Response getResource() {
//        Response response = new Response("Done", user);
//
//        return response;
//    }
//
//    @PostMapping(value = "/save")
//    public Response postCustomer(@RequestBody User user) {
//        user.add(user);
//
//        Response response = new Response("Done", user);
//        return response;
//    }
}
