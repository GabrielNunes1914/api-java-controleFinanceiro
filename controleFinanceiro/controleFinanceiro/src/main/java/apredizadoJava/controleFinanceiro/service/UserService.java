package apredizadoJava.controleFinanceiro.service;

import apredizadoJava.controleFinanceiro.dto.CreateUserDto;
import apredizadoJava.controleFinanceiro.dto.UpdateUserDto;
import apredizadoJava.controleFinanceiro.entity.User;
import apredizadoJava.controleFinanceiro.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int createUser(CreateUserDto createUserDto) {
        var entity =  new User(
                createUserDto.name(),
                createUserDto.email(),
                createUserDto.password(),
                createUserDto.birthDate(),
                Instant.now(),
                null
                );
        var userSaved = userRepository.save(entity);

        return userSaved.getUserId();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public void updateUserById(int id, UpdateUserDto updateUserDto) {

        var userEntity = userRepository.findById(id);

        if (userEntity.isPresent()) {
            var user = userEntity.get();

            if (updateUserDto.name() != null) {
                user.setUsername(updateUserDto.name());
            }

            if (updateUserDto.password() != null) {
                user.setPassword(updateUserDto.password());
            }

            if (updateUserDto.birthDate() != null) {
                user.setBirthDate(updateUserDto.birthDate());
            }

            userRepository.save(user);
        }
    }

    public void deleteById(int id) {

        var userExists = userRepository.existsById(id);

        if (userExists) {
            userRepository.deleteById(id);
        }
    }
}
