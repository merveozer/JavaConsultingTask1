
package net.javaguides.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.javaguides.registration.dao.UserDao;
import net.javaguides.registration.model.User;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private final UserDao userDao = new UserDao();
    
    public UserServlet(){
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.getWriter().append("Served at: ").append(request.getContextPath());
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Views/userregister.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("username");
        String userPassword = request.getParameter("password");
        
        User user = new User();
        user.setUsername(userName);
        user.setPassword(userPassword);
        
        userDao.registerUser(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Views/success.jsp");
        dispatcher.forward(request, response);
    }   
    @Override 
    public String getServletInfo() {
        return "Short description";
    }
 
}

