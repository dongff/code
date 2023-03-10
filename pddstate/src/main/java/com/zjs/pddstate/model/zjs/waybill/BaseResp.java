package com.zjs.pddstate.model.zjs.waybill;


/**
 * @program: jd
 * @description:
 * @author: Lillie
 * @create: 2018-07-13 10:27
 **/
@lombok.Data
public class BaseResp {
	
	public static int SUCCESS = 0;

    public static int FAIlURE = -1;

    private int code;

    private Data data;

    private String description;
    
    private String request_id;

    private String has_next;
    
    private String manager;

    private int pageNo;


}
