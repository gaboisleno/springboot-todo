package com.project.todolist.appUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository userRepository;

    private final AppUserDTOMapper appUserDTOMapper;

    public AppUserService(AppUserDTOMapper appUserDTOMapper) {
        this.appUserDTOMapper = appUserDTOMapper;
    }

    public List<AppUserDTO> findAll() {
        return userRepository.findAll()
        .stream()
        .map(appUserDTOMapper::apply)
        .collect(Collectors.toList());
    }

    public AppUserDTO findUserById(Long id) {
        return userRepository
            .findById(id)
            .map(appUserDTOMapper::apply)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not exist: " + id));
    }

    public AppUserDTO save(AppUser user) {
        AppUser saved = userRepository.save(user);
        return appUserDTOMapper.apply(saved);
    }

}
