package tr.com.getir

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import tr.com.getir.persistency.model.ResponsePayload

/**
 * Created by omeruluoglu on 15.12.2019.
 */
@ControllerAdvice
class ExceptionHandler extends ResponseEntityExceptionHandler {

    ExceptionHandler() {
        super()
    }

    /**
     * Handles any exception messages
     * @param exception
     * @return ResponsePayload with exception message
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    ResponseEntity<ResponsePayload> exception(Exception exception) {
        ResponsePayload errorResponsePayload = new ResponsePayload()
        errorResponsePayload.setCode(1)
        errorResponsePayload.setMsg(exception.getMessage())
        errorResponsePayload.setRecordList(null)
        return new ResponseEntity<ResponsePayload>(errorResponsePayload, HttpStatus.OK)
    }
}
