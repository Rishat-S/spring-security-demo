package ru.netology.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.springsecuritydemo.entity.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    private final List<User> users = Stream.of(
            new User(1L, "Yuriy", "Boyarov"),
            new User(2L, "Eugeniy", "Nakonechnikov"),
            new User(3L, "Denis", "Kats")
    ).collect(Collectors.toList());

    @GetMapping
    public List<User> getAll() {
        return users;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst().orElse(null);
    }

    @PostMapping()
    public User create(@RequestBody User user) {
        this.users.add(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        this.users.removeIf(user -> user.getId().equals(id));
    }
}
