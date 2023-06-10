package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ColumnDefault("false")
    private Boolean isAdmin;

    @Column(length = 8, nullable = false)
    private String birth;

    @Column(length = 16, nullable = false)
    private String phone;

    @Column(nullable = false)
    private String nickname;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<Integer> interest = new ArrayList<Integer>();

    // TODO : ERD의 auth 항목은 현재 제외함. 추후 구체화되면 작성 필요.

    // Builder를 사용한 초기화
    @Builder
    public User(String email, String name, String pwd, String birth, String phone, String nickname, List<Integer> interest) {
        this.email = email;
        this.name = name;
        this.pwd = pwd;
        this.birth = birth;
        this.phone = phone;
        this.nickname = nickname;
        this.interest = interest;
    }

    // update를 통한 수정.
    public void update() {
    }

}
