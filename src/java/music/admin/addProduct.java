/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package music.admin;

import java.io.*;
import java.net.*;
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
public class addProduct extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher dispatch=getServletContext().getRequestDispatcher("/admin/addProduct.jsp");
            String code=request.getParameter("code");
            System.out.println("The code is "+code);
            String description=request.getParameter("description");
            String pric=request.getParameter("price");
            if(code.trim().equalsIgnoreCase("") || description.trim().equalsIgnoreCase("") || pric.trim().equalsIgnoreCase("")){
                dispatch.forward(request, response);
                return;
            }
            double price=Double.valueOf(pric);
            Product prod=new Product();
            prod.setCode(code);
            prod.setDescription(description);
            prod.setPrice(price);
            ProductDB.insert(prod);
            request.setAttribute("product", prod);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
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
