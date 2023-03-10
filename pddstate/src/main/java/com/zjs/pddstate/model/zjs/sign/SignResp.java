package com.zjs.pddstate.model.zjs.sign;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2023-03-10 9:17
 * @modified By:
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignResp {
    private int code;

    private SignData data;

    private String description;

}
