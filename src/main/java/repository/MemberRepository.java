package repository;

import Entity.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<ChatUser, Long> {

}
