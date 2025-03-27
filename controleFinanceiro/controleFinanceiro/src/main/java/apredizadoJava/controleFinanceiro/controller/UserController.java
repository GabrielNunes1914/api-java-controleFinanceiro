package apredizadoJava.controleFinanceiro.controller;

import apredizadoJava.controleFinanceiro.dto.CreateUserDto;
import apredizadoJava.controleFinanceiro.dto.UpdateUserDto;
import apredizadoJava.controleFinanceiro.entity.User;
import apredizadoJava.controleFinanceiro.repository.UserRepository;
import apredizadoJava.controleFinanceiro.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        var userId = userService.createUser(createUserDto);
        return ResponseEntity.created(URI.create("/users/" + userId)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        var user = userService.getUserById(id);
       if (user.isPresent()) {
              return ResponseEntity.ok(user.get());
         } else {
              return ResponseEntity.notFound().build();
       }
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(userService.listUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUserById(@PathVariable("id") int id, @RequestBody UpdateUserDto updateUserDto) {
        userService.updateUserById(id, updateUserDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") int id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
