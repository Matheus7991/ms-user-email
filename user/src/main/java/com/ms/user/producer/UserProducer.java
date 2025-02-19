package com.ms.user.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ms.user.dto.EmailDto;
import com.ms.user.model.UserModel;

@Component
public class UserProducer {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Value(value = "${broker.queue.email.name}")
	private String routingKey;

	public void publishMessageEmail(UserModel userModel) {
		var emailDto = new EmailDto();
		emailDto.setUserId(userModel.getUserId());
		emailDto.setEmailTo(userModel.getEmail());
		emailDto.setSubject("Cadasrto realizado com sucesso!");
		emailDto.setText(userModel.getName() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, "
				+ " aproveite agora todos os recursos da nossa plataforma!");
		
		rabbitTemplate.convertAndSend("", routingKey, emailDto);
	}

}
