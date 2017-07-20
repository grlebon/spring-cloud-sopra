package com.sopra.cloud.erp.reception.service;

import com.sopra.cloud.erp.reception.model.Reception;
import com.sopra.cloud.erp.reception.model.ReceptionStatus;
import com.sopra.cloud.erp.reception.repository.ReceptionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ServiceReception
{
    public ServiceReception(ReceptionRepository receptionRepository) {
        this.receptionRepository = receptionRepository;
    }

    private ReceptionRepository receptionRepository;

    public Reception getReception(long receptionId)
    {
        return receptionRepository.findOne(receptionId);
    }

    public List<Reception> getAllReceptions()
    {
        return receptionRepository.findAll();
    }

    public Reception newReception(Reception reception)
    {
        return receptionRepository.save(reception);
    }

    public Reception newReceptionForPurshaseOrder(long purchaseOrderId, long productId)
    {
        Reception reception = new Reception(purchaseOrderId,productId);
        reception.setStatus(ReceptionStatus.OPEN);
        reception.setDate(new Date());
        return receptionRepository.save(reception);
    }

    public Reception receiveReception(long receptionId)
    {
        Reception reception = this.getReception(receptionId);
        reception.setStatus(ReceptionStatus.RECEIVED);
        return receptionRepository.save(reception);
    }

}
