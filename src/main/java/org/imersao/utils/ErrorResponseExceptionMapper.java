package org.imersao.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.imersao.dto.StickerExceptionResponse;

/**
 *
 * @author SRamos
 */
@Provider
public class ErrorResponseExceptionMapper implements ExceptionMapper<StickerException> {

    @Override
    public Response toResponse(StickerException ex) {
        var formattedDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
        var exceptionResponse = new StickerExceptionResponse();

        exceptionResponse.setError(ex.getMessage());
        exceptionResponse.setErrorDate(formattedDate);

        return Response.status(ex.getHttpStatus()).entity(exceptionResponse).build();
    }

}
