package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @Column(name = "EMAIL", length = 500, nullable = false)
    private String email;

    @Column(length = 25, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String pwd;

    @Column(nullable = false)
    private Boolean isAdmin;

    @Column(length = 8, nullable = false)
    private String age;

    @Column(length = 16, nullable = false)
    private String phone;

    // TODO : ERD의 auth 항목은 현재 제외함. 추후 구체화되면 작성 필요.

    // Builder를 사용한 초기화
    @Builder
    public User(String email, String name, String pwd, Boolean isAdmin, String age, String phone) {
        this.email = email;
        this.name = name;
        this.pwd = pwd;
        this.isAdmin = isAdmin;
        this.age = age;
        this.phone = phone;
    }

    // update를 통한 수정.
    public void update() {
    }

}
