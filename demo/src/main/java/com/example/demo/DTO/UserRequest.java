package main.java.com.example.demo.DTO;

import com.example.demo.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequest {
    private Long id;
    private String email;

    public UserRequest(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
    }

    @Builder
    public UserRequest(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
