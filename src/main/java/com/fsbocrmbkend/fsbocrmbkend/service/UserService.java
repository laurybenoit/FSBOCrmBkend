package com.fsbocrmbkend.fsbocrmbkend.service;

import com.fsbocrmbkend.fsbocrmbkend.exception.InformationExistException;
import com.fsbocrmbkend.fsbocrmbkend.model.User;
import com.fsbocrmbkend.fsbocrmbkend.model.UserProfile;
import com.fsbocrmbkend.fsbocrmbkend.model.request.LoginRequest;
import com.fsbocrmbkend.fsbocrmbkend.model.response.LoginResponse;
import com.fsbocrmbkend.fsbocrmbkend.repository.ProfileRepository;
import com.fsbocrmbkend.fsbocrmbkend.repository.UserRepository;
import com.fsbocrmbkend.fsbocrmbkend.security.JWTUtils;
import com.fsbocrmbkend.fsbocrmbkend.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {
    private UserRepository userRepository;
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public User createUser(User userObject){
        LOGGER.info("Calling createUser from service!");
        if (!userRepository.existsByEmailAddress(userObject.getEmailAddress())){
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            String firstName = userObject.getFirstName();
            String lastName = userObject.getLastName();
            String description = userObject.getUserName();
            UserProfile userProfileObject = new UserProfile(firstName, lastName, description);
            profileRepository.save(userProfileObject);
            userObject.setUserProfile(userProfileObject);
            return userRepository.save(userObject);
        }
        else {
            throw new InformationExistException("User with email address " +
                    userObject.getEmailAddress() + " already exists!");
        }
    }
    public User findUserByEmailAddress(String email){
        return userRepository.findUserByEmailAddress(email);
    }

    public ResponseEntity<?> loginUser(LoginRequest loginRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        final String jwt = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(jwt));
    }


    public User getUserProfile() {
        MyUserDetails userDetails =
                (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<User> user = userRepository.findById(userDetails.getUser().getId());
        return user.get();
    }
}
