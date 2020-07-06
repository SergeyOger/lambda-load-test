package net.broscorp.lambda;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import lombok.Builder;

@Builder
public class CalculationResult {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  private final int statusCode;
  private final Object responseBody;
  private final Map<String, String> headers;
  private final boolean isBase64Encoded;

}
