package aaagt.springboot.rest.app.advice;

import aaagt.springboot.rest.app.exception.InvalidCredentials;
import aaagt.springboot.rest.app.exception.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> hande(InvalidCredentials exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> hande(MethodArgumentNotValidException exception) {
        Map<String, String> errors = exception.getBindingResult().getAllErrors().stream()
                .map((error) -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    return Map.entry(fieldName, errorMessage);
                })
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> e.getValue()
                ));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> hande(UnauthorizedUser exception) {
        System.out.println(exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> hande(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
}
