package kz.runamicon.socialnetwork.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "blogs")
@Builder
public class Blog implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String content;
}
