package ra.appointmentservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.appointmentservice.dto.response.ApiResponseError;
import ra.appointmentservice.exception.ServerUnavailableException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseError<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(new ApiResponseError<>(
                false,
                "Lỗi dữ liệu đầu vào!",
                errors,
                LocalDateTime.now()
        ), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ServerUnavailableException.class)
    public ResponseEntity<ApiResponseError<?>> handleServerUnavailableException(ServerUnavailableException ex){
        return new ResponseEntity<>(new ApiResponseError<>(
                false,
                "Lỗi Server!",
                ex.getMessage(),
                LocalDateTime.now()
        ), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
