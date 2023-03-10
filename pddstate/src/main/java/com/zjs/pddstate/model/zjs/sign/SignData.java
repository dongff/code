package com.zjs.pddstate.model.zjs.sign;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2023-03-10 9:19
 * @modified By:
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignData {
    private String logisticProviderID;
    private String customerCode;
    private String vwocode;
    private String courierNumber;
    private String companyCode;
    private String companyName;
    private String statusDesc;
    private String operator;
    private String operatorContact;
}
