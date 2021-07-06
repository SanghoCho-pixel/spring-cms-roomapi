package ai.wapl.cms.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "TB_MAP_WS_USER_TEST")
@ToString
public class Member implements Serializable {

    @GeneratedValue(strategy =GenerationType.AUTO )
    @Column(name = "USER_ID")
    @Id
    private UUID memberId;

    @Column(name = "MAP_REGI_DATE")
    @CreationTimestamp
    private LocalDateTime regiDate;

    @Column(name = "MAP_MODI_DATE")
    @UpdateTimestamp
    private LocalDateTime modiDate;

    @ManyToOne
    @JoinColumn(name = "room_WS_ID", insertable = false, updatable = false)
    private Room room;

}

