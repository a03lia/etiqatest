package com.a03lia.university.handler;

import com.a03lia.university.exception.CustomException;
import com.a03lia.university.model.ErrorDetails;
import com.a03lia.university.model.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author a03lia
 */
@ControllerAdvice
public class CustomExceptionHandler
{

    private static final Logger log = Logger.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request)
    {
        return new ResponseEntity<>(
                "Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleNotFoundException(Exception ex)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("message", ex.getMessage());

        return new ResponseEntity<>(
                new Response(
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase(),
                        Collections.singletonList(map)
                ), HttpStatus.OK
        );
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<Response> handleBindingResultException(BindException ex)
    {
        List<ErrorDetails> list = new ArrayList<>();
        ex.getFieldErrors().forEach((fr) ->
        {
            list.add(new ErrorDetails(fr.getField(), fr.getDefaultMessage()));
        });

        return new ResponseEntity<>(
                new Response(
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase(),
                        list),
                HttpStatus.OK
        );
    }
    
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Response> handleCustomException(CustomException ce)
    {
        return new ResponseEntity<>(
                new Response(
                        HttpStatus.BAD_REQUEST.value(),
                        ce.getMessage()),
                HttpStatus.OK
        );
    }
}
