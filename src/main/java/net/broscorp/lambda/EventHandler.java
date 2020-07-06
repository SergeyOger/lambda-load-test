package net.broscorp.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.Map;

public class EventHandler implements RequestHandler<Map<String, Object>, CalculationResult> {

  @Override
  public CalculationResult handleRequest(Map<String, Object> input, Context context) {
    return null;
  }
}
