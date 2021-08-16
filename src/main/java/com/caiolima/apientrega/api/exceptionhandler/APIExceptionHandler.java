package com.caiolima.apientrega.api.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice // componente spring que trata exceções de todos os controllers
public class APIExceptionHandler extends ResponseEntityExceptionHandler { //trata de exceptions comuns de HTTP

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        List<CampoIncorreto> camposIncorretos = exception.getBindingResult().getAllErrors()
                .stream().map(objectError -> new CampoIncorreto(((FieldError) objectError).getField(),
                        messageSource.getMessage(objectError, LocaleContextHolder.getLocale()))) //para mensagens padões é objectError.getDefaultMessage()
                .collect(Collectors.toList());

        Erro erro = new Erro(status.value(), LocalDateTime.now(),"Um ou mais campos estão inválidos", camposIncorretos);

        return handleExceptionInternal(exception, erro, headers, status, request);
    }
}
