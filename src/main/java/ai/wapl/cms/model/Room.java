package ai.wapl.cms.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "TB_WS_MST_TEST")
public class Room {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WS_ID")
    private UUID Id;

    @Id
    @Column(name = "WS_NAME")
    private String name;

    @CreationTimestamp
    @Column(name = "WS_REGI_DATE")
    private LocalDateTime wsRegiDate;

    @Column(name = "WS_MODI_DATE")
    @UpdateTimestamp
    private LocalDateTime modiDate;

    @OneToMany(mappedBy = "room")
    private List<Member> memberList;
}
