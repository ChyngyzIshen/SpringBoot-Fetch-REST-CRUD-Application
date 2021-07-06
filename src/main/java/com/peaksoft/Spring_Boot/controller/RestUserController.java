package com.peaksoft.Spring_Boot.controller;

import com.peaksoft.Spring_Boot.model.Role;
import com.peaksoft.Spring_Boot.model.User;
import com.peaksoft.Spring_Boot.repository.RoleRepository;
import com.peaksoft.Spring_Boot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
//@RequestMapping("/api/users")
//@CrossOrigin
public class RestUserController {

    public final UserService userService;
    public final RoleRepository roleRepository;

    public RestUserController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAll(){
        try{
            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getById(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(Principal principal){
        try{
            return new ResponseEntity<>(userService.findByUserName(principal.getName()), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/addUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser (@RequestBody User user){
        try{
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/editUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser (@RequestBody User user){
        try{
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteUser (@PathVariable("id") Long id){
        try{
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/getRoles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Role>> getAllRoles() {
        try {
            return new ResponseEntity<>((List<Role>) roleRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/getUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

}
