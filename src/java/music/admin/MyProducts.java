package music.admin;

/**
 *
 * @author michs
 */
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import music.data.*;

public class MyProducts extends HttpServlet{
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException {
            String url= "/admin/myProducts.jsp";
            //ArrayList<Product> array=ProductDB.selectProducts();
            
            request.setAttribute("items", ProductDB.selectProducts());
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
            Logger.getLogger(MyProducts.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MyProducts.class.getName()).log(Level.SEVERE, null, ex);
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


