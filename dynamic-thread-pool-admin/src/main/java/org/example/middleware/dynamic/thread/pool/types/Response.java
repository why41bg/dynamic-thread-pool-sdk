package org.example.middleware.dynamic.thread.pool.types;

import lombok.*;

import java.io.Serializable;

/**
 * @Classname Response
 * @Description TODO 类描述
 * @Author 魏弘宇
 * @Date 2024/5/21 12:21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -2474596551402989285L;

    private String code;
    private String info;
    private T data;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public enum Code {
        SUCCESS("0000", "调用成功"),
        UN_ERROR("0001", "调用失败"),
        ILLEGAL_PARAMETER("0002", "非法参数"),
        ;

        private String code;
        private String info;

    }

}

