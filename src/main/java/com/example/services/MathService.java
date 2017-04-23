package com.example.services;
/**
 * Created by anup on 22/04/17.
 */
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
public class MathService {

  public String pi() {
    return Double.toString(Math.PI);
  }

  public String calculate(String operation, String x, String y) {
    int total;
    int xInt = Integer.parseInt(x);
    int yInt = Integer.parseInt(y);
    String operator;

    switch (operation) {
      case "add": 			operator = " + ";
                        total = xInt+yInt;
                        break;
      case "subtract": 	operator = " - ";
                        total = xInt-yInt;
                        break;
      case "multiply": 	operator = " * ";
                        total = xInt*yInt;
                        break;
      case "divide":		operator = " / ";
                        total = xInt/yInt;
                        break;
      default: 					operator = " + ";
                        total = xInt+yInt;
                        break;
    }

    return String.format("%s%s%s = %s", x, operator, y, total);
  }

  public String sum(MultiValueMap<String, String> query) {
    String equation = "";
    int sum = 0;

    for (String key : query.keySet()) {
      for (String value : query.get(key)) {
        int index = query.get(key).indexOf(value);

        if (index == 0) {
          equation = value;
        } else {
          equation += " + " + value;
        }

        sum += Integer.parseInt(value);
      }
    }

    return String.format("%s = %s", equation, sum);
  }

  public String rectangleInfo(int length, int width, int height) {
      int volume = length*width*height;
      return String.format("The volume of a %sx%sx%s rectangle is %s", length, width, height, volume);
  }


}