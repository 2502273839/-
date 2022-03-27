package com.example.demo.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class TableRequest implements Serializable {
    public int pageIndex;

    public int pageSize;
}
