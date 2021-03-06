package com.peaksoft.Spring_Boot.controller;

import com.peaksoft.Spring_Boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homepage(){
        return "home";
    }

    @GetMapping("/user")
    public String userPage() {
        return "user";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

//    @GetMapping("/user")
//    public String getUser(Principal principal, Model model){
//        User user = userService.findByUsername(principal.getName());
//        model.addAttribute("user", user);
//        List<Role> roles = roleService.getAllRoles();
//        model.addAttribute("allRoles", roles);
//        return "user-page";
//    }
//
//    @GetMapping("/admin")
//    public String listUsers(@ModelAttribute("user") User user, Model model){
//        List<User> users = userService.findAll();
//        model.addAttribute("users", users);
//        return "admin-page";
//    }
//
//    @GetMapping("/user-add")
//    public String createUserForm(@ModelAttribute("user") User user, ModelMap map){
//        map.addAttribute("user", user);
//        List<Role> roles = roleService.getAllRoles();
//        map.addAttribute("allRoles", roles);
//        return "user-add";
//    }
//
//    @PostMapping("/user-add")
//    public String createUser(User user, @RequestParam Map<String, String> form){
//        List<String> roles = roleService.getRoleNamesToList();
//        Set<String> strings = new HashSet<>(roles);
//        user.getRoles().clear();
//        for (String key: form.keySet()) {
//            if (strings.contains(key)) {
//                user.getRoles().add(roleService.getRoleByName(key));
//            }
//        }
//        userService.save(user);
//        return "redirect:/admin";
//    }
//
//    @GetMapping("/user-update/{id}")
//    public String updateUserForm(@PathVariable("id") Long id, ModelMap map, Principal principal){
//        User user = userService.findById(id);
//        map.addAttribute("user", user);
//        List<Role> roles = roleService.getAllRoles();
//        map.addAttribute("allRoles", roles);
//        return "admin-page";
//    }
//
//    @PostMapping("/user-update/{id}")
//    public String updateUser(@ModelAttribute("user") User user, @RequestParam Map<String, String> form){
//        List<String> roles = roleService.getRoleNamesToList();
//        Set<String> strings = new HashSet<>(roles);
//        user.getRoles().clear();
//        for (String key: form.keySet()) {
//            if (strings.contains(key)) {
//                user.getRoles().add(roleService.getRoleByName(key));
//            }
//        }
//        userService.save(user);
//        return "redirect:/admin";
//    }
//
//    @GetMapping("/user-delete/{id}")
//    public String deleteUser(@PathVariable("id") Long id){
//        userService.deleteById(id);
//        return "redirect:/admin";
//    }

}
