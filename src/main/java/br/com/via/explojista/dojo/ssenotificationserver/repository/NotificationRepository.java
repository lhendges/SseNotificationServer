package br.com.via.explojista.dojo.ssenotificationserver.repository;

import br.com.via.explojista.dojo.ssenotificationserver.model.NotificationModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotificationRepository extends CrudRepository<NotificationModel, Long> {

    List<NotificationModel> findAllByRecipientIdAndReadFalse(Long recipientId);

}
