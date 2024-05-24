package kz.runamicon.socialnetwork.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.runamicon.socialnetwork.dto.UpdateUsernameRequest;
import kz.runamicon.socialnetwork.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User Controller", description = "Controller responsible for manipulation with user data")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Operation(
            summary = "User username update",
            description = "Allows to user update their username"
    )
    @PostMapping("/update_username")
    @ResponseStatus(HttpStatus.OK)
    public String updateUsername(
            @RequestBody
            @Parameter(description = "Update username request")
            UpdateUsernameRequest request
    ) {
        return userService.updateUsername(request);
    }
}
