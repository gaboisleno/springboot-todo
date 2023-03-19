package com.project.todolist.appUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.todolist.NotFoundException;
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
            .orElseThrow(() -> new NotFoundException("User: " + id + "not found"));
    }

    public AppUserDTO save(AppUser user) {
        AppUser saved = userRepository.save(user);
        return appUserDTOMapper.apply(saved);
    }

}
