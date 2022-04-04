package com.example.demo.model.request;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class RoomRequest implements Serializable {
    Date day;
    String room;
    String userName;
}
