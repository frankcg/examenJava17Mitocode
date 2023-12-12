package com.frank.laura.examenJava17Mitocode.exception;

import java.time.LocalDateTime;

public record CustomErrorResponse (
        LocalDateTime dateTime,
        String message,
        String path
) {
}
