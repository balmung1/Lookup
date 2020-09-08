package RoomSystem;

import RoomSystem.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MeetingRoomStatusViewHandler {


    @Autowired
    private MeetingRoomStatusRepository meetingRoomStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomRegistered_then_CREATE_1 (@Payload RoomRegistered roomRegistered) {
        try {
            if (roomRegistered.isMe()) {
                // view 객체 생성
                MeetingRoomStatus meetingRoomStatus = new MeetingRoomStatus();
                // view 객체에 이벤트의 Value 를 set 함
                meetingRoomStatus.setRoomId(roomRegistered.getRoomId());
                meetingRoomStatus.setRoomName(roomRegistered.getRoomName());
                meetingRoomStatus.setLocation(roomRegistered.getLocation());
                // view 레파지 토리에 save
                meetingRoomStatusRepository.save(meetingRoomStatus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_2 (@Payload Reserved reserved) {
        try {
            if (reserved.isMe()) {
                // view 객체 생성
                MeetingRoomStatus meetingRoomStatus = new MeetingRoomStatus();
                // view 객체에 이벤트의 Value 를 set 함
                meetingRoomStatus.setReservationId(reserved.getReservationId());
                meetingRoomStatus.setRoomId(reserved.getRoomId());
                meetingRoomStatus.setUserId(reserved.getUserId());
                // view 레파지 토리에 save
                meetingRoomStatusRepository.save(meetingRoomStatus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDemerited_then_CREATE_3 (@Payload Demerited demerited) {
        try {
            if (demerited.isMe()) {
                // view 객체 생성
                MeetingRoomStatus meetingRoomStatus = new MeetingRoomStatus();
                // view 객체에 이벤트의 Value 를 set 함
                meetingRoomStatus.setDemeritId(demerited.getDemeritId());
                meetingRoomStatus.setUserId(demerited.getUserId());
                // view 레파지 토리에 save
                meetingRoomStatusRepository.save(meetingRoomStatus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCanceled_then_UPDATE_1(@Payload ReservationCanceled reservationCanceled) {
        try {
            if (reservationCanceled.isMe()) {
                // view 객체 조회
                List<MeetingRoomStatus> meetingRoomStatusList = meetingRoomStatusRepository.findByReservationId(reservationCanceled.getReservationId());
                for(MeetingRoomStatus meetingRoomStatus : meetingRoomStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    meetingRoomStatus.setRoomStatus(reservationCanceled.getRoomStatus());
                    // view 레파지 토리에 save
                    meetingRoomStatusRepository.save(meetingRoomStatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomDelete_then_DELETE_1(@Payload RoomDelete roomDelete) {
        try {
            if (roomDelete.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                meetingRoomStatusRepository.deleteByRoomId(roomDelete.getRoomId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}