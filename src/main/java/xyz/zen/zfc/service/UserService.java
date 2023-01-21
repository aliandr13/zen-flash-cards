package xyz.zen.zfc.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.zen.zfc.dto.SignUpDto;
import xyz.zen.zfc.entity.UserEntity;
import xyz.zen.zfc.exception.UserNotFoundException;
import xyz.zen.zfc.mapper.UserMapper;
import xyz.zen.zfc.model.Role;
import xyz.zen.zfc.model.User;
import xyz.zen.zfc.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public User getById(final UUID id) {
        return userRepository.findById(id)
                .map(userMapper::map)
                .orElseThrow(() -> new UserNotFoundException("id: " + id));
    }

    public List<User> getAll() {
        return userRepository.findAll().stream().map(userMapper::map).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        Optional<UserEntity> userByEmail = userRepository.findUserByEmail(email);
        Optional<User> user = userByEmail.map(userMapper::map);
        return user.orElseThrow(() -> new UsernameNotFoundException("User not found; Email: " + email));
    }

    public User createUser(User user) {
        return userMapper.map(userRepository.save(userMapper.map(user)));
    }

    public User createUser(SignUpDto dto) {
        User user = User.builder()
                .email(dto.getEmail())
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .enabled(true)
                .role(Role.USER)
                .build();

        return userMapper.map(userRepository.save(userMapper.map(user)));
    }
}
