package com.zjs.pddstate.model.zjs.sign;

import lombok.Data;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2023-03-10 9:22
 * @modified By:
 */
@Data
public class SignReq {
    private String logisticProviderID;
    private String customerCode;
    private String vwocode;
}
