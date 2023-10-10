package DTO;

import Entity.ChatUser;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatUserDTO {
    // Entity.ChatUser 에 따라서 만들기
    private Long id;
    private String nickName;
    private String provider;
    private String email;


    // Member 엔티티
    public static ChatUserDTO of(ChatUser chatUserEntity){
        ChatUserDTO chatUserDTO = ChatUserDTO.builder()
                .id(chatUserEntity.getId())
                .nickName(chatUserEntity.getNickName())
                .build();
        return chatUserDTO;
    }
}
