package RoomSystem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MeetingRoomStatusRepository extends CrudRepository<MeetingRoomStatus, Long> {

    List<MeetingRoomStatus> findByReservationId(Long reservationId);

        void deleteByRoomId(Long roomId);
}