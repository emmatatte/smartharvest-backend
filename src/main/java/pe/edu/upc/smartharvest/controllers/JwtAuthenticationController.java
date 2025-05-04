package pe.edu.upc.smartharvest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.smartharvest.entities.Users;
import pe.edu.upc.smartharvest.securities.JwtRequest;
import pe.edu.upc.smartharvest.securities.JwtResponse;
import pe.edu.upc.smartharvest.securities.JwtTokenUtil;
import pe.edu.upc.smartharvest.servicesimplements.JwtUserDetailsService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private JwtUserDetailsService jwtService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/register-simple")
    public ResponseEntity<String> registerWithCrop(@RequestBody SimpleRegisterDTO dto) {
        jwtService.registerSimple(dto);
        return ResponseEntity.ok("User + crop + parcel registered successfully");
    }

    @PutMapping("/users/{userId}/preferences")
    public ResponseEntity<Users> updatePreferences(
            @PathVariable Long userId,
            @RequestParam String language,
            @RequestParam String theme) {
        Users updatedUser = jwtService.updateUserPreferences(userId, language, theme);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/users/{userId}/favorite-sections")
    public ResponseEntity<Users> updateFavoriteSections(
            @PathVariable Long userId,
            @RequestBody List<String> favoriteSections) {
        Users updatedUser = jwtService.updateFavoriteSections(userId, favoriteSections);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/users/{userId}/share")
    public ResponseEntity<String> logShareAction(
            @PathVariable Long userId,
            @RequestParam String content,
            @RequestParam String platform) {
        jwtService.logShareAction(userId, content, platform);
        return ResponseEntity.ok("Share action logged.");
    }
}