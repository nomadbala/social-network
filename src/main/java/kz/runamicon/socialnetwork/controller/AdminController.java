package kz.runamicon.socialnetwork.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.runamicon.socialnetwork.dto.user.UserDto;
import kz.runamicon.socialnetwork.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Admin controller", description = "Controller responsible for admin actions")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin/")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    private final UserService userService;

    @Operation(
            summary = "Find all users (admin only)",
            description = "Allows admin find all users"
    )
    @GetMapping("/users/")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> findAllUsers() {
        return userService.findAll();
    }

    @Operation(
            summary = "Find user by id (admin only)",
            description = "Allows admin to find user by id"
    )
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public UserDto findUserById(
            @PathVariable
            @Parameter(description = "User`s id")
            Long id
    ) {
        return userService.findById(id);
    }
}
