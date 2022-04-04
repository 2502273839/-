package com.example.demo.model.response;

import com.example.demo.entity.client.ApplyTicket;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QueryApplyTicketResponse implements Serializable {
    private int total;

    private List<ApplyTicket> items;
}
