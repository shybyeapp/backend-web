package app.shybye.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Challenge not found")
public class ChallengeNotFoundException extends RuntimeException {
}
