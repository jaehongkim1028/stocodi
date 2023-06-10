package com.example.demo.repository;

import com.example.demo.domain.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import org.assertj.core.api.Assertions;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest() {
        // Given
        User user = User.builder()
                .email("test@example.com")
                .birth("20010927")
                .phone("01012345678")
                .name("test")
                .nickname("testnick")
                .pwd("password")
                .interest(List.of(1, 2, 3))
                .build();
        // When
        userRepository.save(user);
        // Then
        Assertions.assertThat(user.getEmail()).isEqualTo("test@example.com");
    }

    @Test
    @Order(2)
    public void getUserTest(){
        // Given
        User user = userRepository.findByEmail("test@example.com");

        // When
        // Then
        Assertions.assertThat(user.getEmail()).isEqualTo("test@example.com");
    }

    @Test
    @Order(3)
    public void getListOfUsersTest(){
        // Given
        List<User> users = userRepository.findAll();

        // When
        // Then
        Assertions.assertThat(users.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest(){
        // Given
        User user = userRepository.findByEmail("test@example.com");

        // When
        user.updateUser("updateUserName", user.getPwd(), user.getBirth(), user.getPhone(), user.getNickname(), user.getInterest());
        User userUpdated =  userRepository.save(user);

        // Then
        Assertions.assertThat(userUpdated.getName()).isEqualTo("updateUserName");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest(){
        // Given
        User user = userRepository.findByEmail("test@example.com");
        // When
        userRepository.delete(user);
        User userResult = userRepository.findByEmail("ram@gmail.com");
        // Then
        Assertions.assertThat(userResult).isNull();
    }

}
