package ai.wapl.cms.repository;


import ai.wapl.cms.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class RoomRepository {

    private final EntityManager em;

    public Room find(String name) {
        return em.find(Room.class, name);
    }

    public void save(Room room) {
        em.persist(room);
    }
}
