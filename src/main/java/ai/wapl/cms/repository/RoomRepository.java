package ai.wapl.cms.repository;


import ai.wapl.cms.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RoomRepository {

    private final EntityManager em;

    @Transactional
    public Optional<Room> find(String name) {
        String jpql = "select a from Room a where a.name = :foo";
        TypedQuery<Room> query = em.createQuery(jpql, Room.class);
        query.setParameter("foo", name);
        List<Room> resultList = query.getResultList();

        Room result;
        if(resultList.size() >= 1){
            result = resultList.get(0);
        } else {
            result = null;
        }

        return Optional.ofNullable(result);
    }

    @Transactional
    public void save(Room room) {
        em.persist(room);

    }

}
