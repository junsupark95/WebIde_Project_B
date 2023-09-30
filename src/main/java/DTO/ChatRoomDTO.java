package DTO;

import lombok.*;

import java.util.HashMap;
import java.util.UUID;

// Stomp 를 통해 pub/sub 를 사용하면 구독자 관리가 알아서 된다.
// 따라서 따로 세션 관리를 하는 코드를 작성할 필도 없고,
// 메시지를 다른 세션의 클라이언트에게 발송하는 것도 구현 필요가 없다.
@Data
@Builder

public class ChatRoomDTO {
    private String roomId; // 채팅방 아이디
    private String roomName; // 채팅방 이름
    private int userCount; // 채팅방 인원수
    private int maxUserCnt; // 채팅방 최대 인원
    // 문자열 키와 값으로 구성된 데이터를 저장하기 위한 HashMap< key , value > 생성
    // HashMap<>은 userlist 변수에 저장
    // 키(String 타입): 사용자의 고유한 식별자를 나타내는 문자열, 사용자 아이디나 다른 고유한 값일 수 있다.
    // 값(String 타입): 사용자의 이름 또는 다른 정보를 나타내는 문자열
    // 채팅방에 참여 중인 사용자 목록을 나타내기 위해 사용
    private HashMap<String, String> userlist;
    // private HashMap<String, String> userlist = new HashMap<String, String>();

    // roomName: 생성될 채팅방의 이름을 나타내는 문자열
    // 메소드를 호출할 때, 사용자가 지정한 채팅방의 이름
    // 이 값은 새로운 채팅방의 초기 설정에 사용됨
    // 예: "일반 대화방", "프로젝트 회의실" 등
    /* public ChatRoomDTO create(String roomName){
        // ChatRoomDTO 객체를 생성
        ChatRoomDTO chatRoom = new ChatRoomDTO();

        // chatRoom 객체의 roomId 필드에 무작위로 생성된 UUID를 문자열로 변환하여 할당
        chatRoom.roomId = UUID.randomUUID().toString();
        // chatRoom 객체의 roomName 필드에 전달된 roomName 값을 할당
        chatRoom.roomName = roomName;

        // 생성된 chatRoom 객체를 반환합니다.
        return chatRoom;
    } */
}