package com.maan.life.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Option {

    private Object code;
    private Object subCode;
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
}
