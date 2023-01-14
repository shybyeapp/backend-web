package app.shybye.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Completed Challenge not found.")
public class CompletedChallengeNotFoundException extends RuntimeException {
}
