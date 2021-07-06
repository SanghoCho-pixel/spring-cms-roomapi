package ai.wapl.cms.repository;

import ai.wapl.cms.model.Member;
import ai.wapl.cms.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    @Transactional
    public Member find(String name) {
        return em.find(Member.class, name);
    }

    @Transactional
    public void save(Member member) {
        em.persist(member);

    }

}
