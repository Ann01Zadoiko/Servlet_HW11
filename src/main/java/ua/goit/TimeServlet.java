package ua.goit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String timezoneParameter = req.getParameter("timezone");

        String timezone = writeTimezone(Integer.parseInt(timezoneParameter));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz");
        String current = simpleDateFormat.format(new Date());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        String result = simpleDateFormat.format(new Date());

        req.setAttribute("timezoneCurrent", timezone);
        req.setAttribute("currentTime", current);
        req.setAttribute("resultTime", result);

        RequestDispatcher dispatcher = req.getRequestDispatcher("time.jsp");
        dispatcher.forward(req, resp);
    }

    private static String writeTimezone(int timezoneParameter){
        String timezone = "GMT";

        if (timezoneParameter > -1 && timezoneParameter < 13){
            timezone += "+" + timezoneParameter;
        }

        return timezone;
    }
}