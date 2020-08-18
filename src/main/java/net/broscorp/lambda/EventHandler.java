package net.broscorp.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class EventHandler implements RequestHandler<Map<String, Object>, CalculationResult> {

  @Override
  public CalculationResult handleRequest(Map<String, Object> input, Context context) {

    String rawRequestPath = (String) input.get("path");
    String[] params = rawRequestPath.split("/");

    BigInteger argument = BigInteger.valueOf(Long.parseLong(params[params.length - 1]));

    BigInteger result = BigInteger.ONE;

    while (!argument.equals(BigInteger.ZERO)) {
      result = result.multiply(argument);
      argument = argument.subtract(BigInteger.ONE);
    }

    Map<String, String> headers = new HashMap<>();
    headers.put("X-Powered-By", "AWS Lambda, Java11 & serverless");
    headers.put("Content-Type", "application/json");
    return CalculationResult.builder().setStatusCode(200)
        .setRawBody("Request path: " + rawRequestPath + "Calculation result: " + result)
        .setHeaders(headers).build();
  }
}
