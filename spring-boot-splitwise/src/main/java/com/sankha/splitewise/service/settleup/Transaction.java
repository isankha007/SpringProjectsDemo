package com.sankha.splitewise.service.settleup;

import com.sankha.splitewise.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private User from;
    private User to;
    private double amount;
}
