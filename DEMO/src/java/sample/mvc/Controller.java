/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ThangVo
 */
public class Controller extends HttpServlet {

    final private String errorPage = "ErrorPage.jsp";
    final private String homePage = "index.jsp";
    final private String welcomePage = "WelcomePage.jsp";
    final private String registerPage = "register.jsp";
    final private String showPage = "Show.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("btAction");
        if (action.equals("Login")) {
            String logemail = request.getParameter("username");
            String logpass = request.getParameter("password");

            UserDatabase db = new UserDatabase(MSSQLConnection.getConnection());
            Users user = db.login(logemail, logpass);
            String url = errorPage;
            if (user != null) {
                url = welcomePage;
                HttpSession session = request.getSession();
                session.setAttribute("logUser", user);

            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } else if (action.equals("Search")) {
            String txtsearch = request.getParameter("txtSearch");
            UserDatabase db = new UserDatabase(MSSQLConnection.getConnection());
            ArrayList<Users> al = db.nvList(txtsearch);
            request.setAttribute("myStudents", al);
            RequestDispatcher rd = request.getRequestDispatcher(showPage);
            rd.forward(request, response);
        }else if (action.equals("tryAgain")) {
                RequestDispatcher rd = request.getRequestDispatcher(homePage);
                rd.forward(request, response);
        }else if (action.equals("Delete")) {
                String username = request.getParameter("username");
                String name = request.getParameter("txtSearch");
                UserDatabase db = new UserDatabase(MSSQLConnection.getConnection());
                
                boolean result = db.deleteRecord(username);
                String url = "Controller?btAction=Search&txtSearch" + name;
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }else if(action.equals("register")){
                 RequestDispatcher rd = request.getRequestDispatcher(registerPage);
                rd.forward(request, response);
            } else if (action.equals("Register")) {
                String username = request.getParameter("txtUser");
                String password = request.getParameter("txtPass");
                String lastname = request.getParameter("txtLast");
                String admin = request.getParameter("chkAdmin");
                UserDatabase db = new UserDatabase(MSSQLConnection.getConnection());
                boolean roles = false;
                if(admin !=null){
                   roles=true; 
                }
                Users s = new Users(username, password, lastname, roles);
                boolean result = db.saveUser(s);
                RequestDispatcher rd = request.getRequestDispatcher(homePage);
                rd.forward(request, response);
            } else if (action.equals("Update")) {
                String username = request.getParameter("txtUsername");
                String lastname = request.getParameter("txtLast");
                String admin = request.getParameter("chkAdmin");
                boolean roles = false;
                if (admin != null) {
                    roles = true;
                }
                String name = request.getParameter("txtSearch");
                UserDatabase db = new UserDatabase(MSSQLConnection.getConnection());
               
                boolean result = db.updateRecord(username, lastname, roles);
                String url = "Controller?btAction=Search&txtSearch=" + name;
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
