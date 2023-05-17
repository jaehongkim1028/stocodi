
package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Like extends BaseTimeEntity {
    @Id
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CONTENT_ID")
    private Long contentId;

    // Builder를 통한 초기화
    @Builder
    public Like(String email, Long contentId) {
        this.contentId = contentId;
        this.email = email;
    }
}
