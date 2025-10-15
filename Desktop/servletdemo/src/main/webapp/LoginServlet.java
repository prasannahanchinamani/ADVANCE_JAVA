package src.main.webapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hardcoded validation
        if("admin".equals(username) && "1234".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("AfterLogin.jsp");
        } else {
            // If login fails, send error message
            request.setAttribute("errorMessage", "Invalid username or password. Please try again.");
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        }
    }
}
