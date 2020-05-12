package com.hlife.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private int id;
    private String name;
    private Balance balance;

    public User(int id, String name) {
        this(id, name, null);
    }

}
