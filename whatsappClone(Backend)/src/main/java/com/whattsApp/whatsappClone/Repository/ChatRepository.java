package com.whattsApp.whatsappClone.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.whattsApp.whatsappClone.Model.Chat;
import com.whattsApp.whatsappClone.Model.app_user;


public interface ChatRepository extends JpaRepository<Chat, Integer> {
	
	@Query("select c from Chat c join c.users u where u.id=:userId")
	public List<Chat> findChatByUserId(@Param("userId")Integer userId);
	
	
	@Query("select c from Chat c where c.isGroup=false And :user Member of c.users And :reqUser Member of c.users")
	public Chat findSingleChatByUserIds(@Param("user") app_user user, @Param("reqUser") app_user reqUser);


}
