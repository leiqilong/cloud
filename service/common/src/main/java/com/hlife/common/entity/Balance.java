package com.hlife.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Balance implements Serializable {
    private int id;
    private int diamond;
    private int ticket;
    private String message;

    public Balance(int id, int diamond,  int ticket) {
        this(id, diamond, ticket, "ok");
    }
}
