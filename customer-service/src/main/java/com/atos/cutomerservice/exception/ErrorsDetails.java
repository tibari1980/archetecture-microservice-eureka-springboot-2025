package com.atos.cutomerservice.exception;

import java.time.LocalDateTime;

public record ErrorsDetails(

		LocalDateTime timestamp, String message, String details, String codeErrors) {

}
