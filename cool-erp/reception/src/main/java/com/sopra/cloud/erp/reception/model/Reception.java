package com.sopra.cloud.erp.reception.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Reception {

    public Reception() {
    }

    public Reception(long purchaseOrderId, long productId) {
        this.purchaseOrderId = purchaseOrderId;
        this.productId = productId;
    }

    @Id
    @GeneratedValue
    private long id;

    private long purchaseOrderId;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ReceptionStatus getStatus() {
        return status;
    }

    public void setStatus(ReceptionStatus status) {
        this.status = status;
    }

    private long productId;

    private Date date;

    private ReceptionStatus status;

    public long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
