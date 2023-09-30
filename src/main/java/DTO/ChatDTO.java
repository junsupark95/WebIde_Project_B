package DTO;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ChatDTO {
    // 메시지 타입 : 입장, 퇴장, 채팅
    // 메시지 타입에 따라 동작하는 구조가 달라짐. 입장(ENTER), 퇴장(LEAVE)의 경우 입장/퇴장 이벤트 발생
    // 채팅(TAKE)는 채팅 내용이 해당 채팅방을 SUB 하고 있는 모든 클라이언트에 전달 됨.
    public enum MessageType {
        ENTER, LEAVE, TAKE;
    }

    private MessageType type; // 메시지 타입
    private String roomId; // 방 번호
    private String sender; // 채팅 보낸 사람
    private String message; // 메시지
    private String time; // 채팅 발송 시간
}
