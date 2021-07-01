package ai.wapl.cms.controller;

import ai.wapl.cms.model.Room;
import ai.wapl.cms.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/CMS/room-api")
public class RoomController {

    private final RoomRepository roomRepository;

    @GetMapping("/create/{roomName}")
    @Transactional
    public Room createRoom(@PathVariable("roomName") String name) {
        Room room = Room.builder()
                .name(name)
                .build();
        roomRepository.save(room);
        return room;
    }

    @GetMapping("/get/{roomName}")
    @Transactional
    public Room getRoom(@PathVariable("roomName") String name) {
        return roomRepository.find(name);
    }


}
