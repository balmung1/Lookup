package RoomSystem;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="MeetingRoomStatus_table")
public class MeetingRoomStatus {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long roomId;
        private String roomName;
        private String location;
        private Long reservationId;
        private String roomStatus;
        private String userId;
        private Long demeritId;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getRoomId() {
            return roomId;
        }

        public void setRoomId(Long roomId) {
            this.roomId = roomId;
        }
        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }
        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
        public Long getReservationId() {
            return reservationId;
        }

        public void setReservationId(Long reservationId) {
            this.reservationId = reservationId;
        }
        public String getRoomStatus() {
            return roomStatus;
        }

        public void setRoomStatus(String roomStatus) {
            this.roomStatus = roomStatus;
        }
        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
        public Long getDemeritId() {
            return demeritId;
        }

        public void setDemeritId(Long demeritId) {
            this.demeritId = demeritId;
        }

}
