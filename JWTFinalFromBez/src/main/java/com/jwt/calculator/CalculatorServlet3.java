package com.jwt.calculator;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value = "/calc3")
@CrossOrigin("http://localhost:4200")
public class CalculatorServlet3 extends HttpServlet {
    double initialValue = 0.0;
    Button[] buttons;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader reader = request.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }

        Gson gson = new Gson();
        buttons = gson.fromJson(requestBody.toString(), Button[].class);
        System.out.println(buttons[0]);

        String currentOperationString = "";
        double value = 0.0;
        for (int i = 0; i < buttons.length; i++) {

            if (i==0 && buttons[0].type.equals("NUMBER")) {
                initialValue = Double.parseDouble(buttons[0].value);
                continue;
            }

            String type = buttons[i].type;
            String stringValue = buttons[i].value;

            if (type.equals("NUMBER")) {
                value = Double.parseDouble(stringValue);
                performOperation(value, currentOperationString);
                currentOperationString = "";
            }
            if(type.equals("OPERATION") ){
                currentOperationString=stringValue;
            }
            if (type.equals("OPERATION") && i>0) {
                    if (buttons[i - 1].value.equals("SUBTRACTION") && stringValue.equals("ADDITION")) {
                        currentOperationString = "SUBTRACTION";
                    } else if (buttons[i - 1].value.equals("SUBTRACTION") && stringValue.equals("SUBTRACTION")) {
                        currentOperationString = "ADDITION";
                    }
            }
        }
        System.out.println(initialValue);
        response.setContentType("text");
        PrintWriter out = response.getWriter();

        out.print(initialValue);
        initialValue = 0;
        response.setStatus(HttpServletResponse.SC_OK);
    }

    private void performOperation(double operand, String operation) {
        switch (operation) {
            case "ADDITION":
                initialValue += operand;
                break;
            case "SUBTRACTION":
                initialValue -= operand;
                break;
            case "MULTIPLICATION":
                initialValue *= operand;
                break;
            case "DIVISION":
                initialValue /= operand;
                break;
        }

    }
}


//[
//        {"type":"NUMBER","value":"25"},
//        {"type":"OPERATION","value":"ADDITION"},
//        {"type":"NUMBER","value":"365"},
//        {"type":"OPERATION","value":"SUBTRACTION"},
//        {"type":"NUMBER","value":"5"},
//        {"type":"OPERATION","value":"SUBTRACTION"},
//        {"type":"NUMBER","value":"15"},
//        {"type":"OPERATION","value":"EQUAL"}
//        ]

//[       {"type":"NUMBER","value":"2"},
//        {"type":"OPERATION","value":"ADDITION"},
//        {"type":"NUMBER","value":"3"}
//]

//New code for functionality
//            if (type.equals("FUNCTION")) {
//                    if (stringValue.equals("C")) {
//                    buttons[i - 1].value = "";
//                    buttons[i - 1].type = "";
//                    } else {
//                    value = 0.0;
//                    currentOperationString = "";
//                    initialValue = 0.0;
//                    }
//                    }