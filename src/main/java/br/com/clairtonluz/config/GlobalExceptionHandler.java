package br.com.clairtonluz.config;

import br.com.clairtonluz.exception.BadRequestException;
import br.com.clairtonluz.exception.ConflitException;
import br.com.clairtonluz.model.pojo.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(ConflitException.class)
    @ResponseBody
    public ErrorInfo handleConflict(HttpServletRequest req, Exception e) {
        return new ErrorInfo(req.getRequestURI(), e);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ErrorInfo handleEmpty(HttpServletRequest req, Exception e) {
        return new ErrorInfo(req.getRequestURI(), e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorInfo handleException(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        return new ErrorInfo(req.getRequestURI(), e);
    }
}
