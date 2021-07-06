package ai.wapl.cms.controller;


import ai.wapl.cms.model.Member;
import ai.wapl.cms.model.Room;
import ai.wapl.cms.repository.MemberRepository;
import ai.wapl.cms.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/CMS/members")
public class MemberController {

    private final MemberRepository memberRepository;
    private final RoomRepository roomRepository;
    private final EntityManager em;

    @GetMapping("/create/{roomName}")
    @Transactional
    public Member createMember(@PathVariable("roomName") String name) {

        Optional<Room> optRoom = roomRepository.find(name);

        Room room;
        if(optRoom.isPresent()){
            room = optRoom.get();
        } else{
            room = Room.builder().name(name).build();
            roomRepository.save(room);
        }
        Member member = Member.builder()
                .room(room)
                .build();

        memberRepository.save(member);


        member.setRoom(room);
//        room.getMemberList().add(member);

        System.out.println("member = " + member);

        em.flush();
        em.clear();

        return member;
    }

}
