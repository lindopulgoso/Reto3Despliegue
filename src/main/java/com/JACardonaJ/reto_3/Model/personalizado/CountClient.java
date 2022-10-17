package com.JACardonaJ.reto_3.Model.personalizado;

import com.JACardonaJ.reto_3.Model.Client;

import javax.swing.event.CaretListener;

public class CountClient {
    private  Long total ;
    private Client client;

    public CountClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
