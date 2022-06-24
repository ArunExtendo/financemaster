package com.maan.life.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Option {

    private Object code;
    private Object subCode;

    private Object subCode2;
    private String value;

    public Option(Object code, String value) {
        this.code = code;
        this.value = value;
    }

    public Option(Object code, Object subCode, String value) {
        this.code = code;
        this.subCode = subCode;
        this.value = value;
    }


    public Option(Object code, Object subCode, Object subCode2,String value) {
        this.code = code;
        this.subCode = subCode;
        this.value = value;
        this.subCode2 = subCode2;

    }
    
}
