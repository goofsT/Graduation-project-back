package com.softeem.iov.auth;
import com.softeem.iov.utils.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 在请求体中有数据，但数据内容不符合验证规则时触发。
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseData<Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        System.out.println("MethodArgumentNotValidException");
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity
                //成功的状态码
                .status(HttpStatus.resolve(200)) // 或其他适当的状态码
                .body(ResponseData.error(400, "请求参数错误"));
    }

    /**
     * 在请求体中没有数据时触发。
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseData<Object>> handleValidationExceptions(HttpMessageNotReadableException ex) {
        System.out.println("HttpMessageNotReadableException");
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "请求参数错误!");
        return ResponseEntity
                .status(HttpStatus.resolve(200)) // 或其他适当的状态码
                .body(ResponseData.error(400, "请求参数错误"));
    }
}
