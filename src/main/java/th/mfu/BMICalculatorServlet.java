package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        Double weight = Double.parseDouble(request.getParameter("weight"));
        Double height = Double.parseDouble(request.getParameter("height"));
        //TODO: calculate bmi
        Long bmi = Math.round(weight / (height * height));
        //TODO: determine the built from BMI
        String builtType;
            if (bmi < 18.5) {
                builtType = "underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                builtType = "normal";
            } else if (bmi >= 25 && bmi < 30) {
                builtType = "overweight";
            } else if (bmi >= 30 && bmi < 35) {
                builtType = "obese";
            } else if (bmi >= 35) {
                builtType = "extremely obese";
            } else {
                builtType = "error";
            }
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi", bmi);
        request.setAttribute("builtType", builtType);
        //TODO: forward to jsp
        request.getRequestDispatcher("/bmi_result.jsp").forward(request, response);
    }
    
}
