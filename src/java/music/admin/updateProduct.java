/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package music.admin;

import java.io.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import music.data.*;
import music.business.*;


/**
 *
 * @author stefano
 */
public class updateProduct extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
            String code=request.getParameter("code");
            String description=request.getParameter("description");
            String pric=request.getParameter("price");
            double price=Double.valueOf(pric);
            ServletContext cont= getServletContext();
            RequestDispatcher dispatch=getServletContext().getRequestDispatcher("/admin/updateProduct.jsp");
            if(code.trim().equalsIgnoreCase("") || description.trim().equalsIgnoreCase("") || pric.trim().equalsIgnoreCase("")){
                dispatch.forward(request, response);
                return;
            }
            Product prod=new Product();
            prod.setCode(code);
            prod.setDescription(description);
            prod.setPrice(price);
            ProductDB.update(prod);
            String url= "/index.jsp";
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(updateProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(updateProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
