package com.parthu.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.parthu.binding.ErrorInfo;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception e){
		
		String message = e.getMessage();
		ErrorInfo info=new ErrorInfo();
		info.setMsg(message);
		info.setCode("EMPEX005");
		info.setWhen(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(info,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
