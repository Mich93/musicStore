package music.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.ArrayList;

import music.business.*;

public class DisplayInvoiceServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {        
        HttpSession session = request.getSession();

        String invoiceNumberString = request.getParameter("invoiceNumber");
        int invoiceNumber = Integer.parseInt(invoiceNumberString);
        ArrayList<Invoice> unprocessedInvoices =
            (ArrayList<Invoice>) session.getAttribute("unprocessedInvoices");

        Invoice invoice = null;
        for (Invoice unprocessedInvoice : unprocessedInvoices) {
            invoice = unprocessedInvoice;
            if (invoice.getInvoiceNumber() == invoiceNumber)
            {
                break;
            }
        }

        User user = invoice.getUser();
        ArrayList<LineItem> lineItems = invoice.getLineItems();
        
        session.setAttribute("user", user);
        session.setAttribute("invoice", invoice);
        Cart cart = new Cart();
        cart.setItems(lineItems);
        session.setAttribute("cart", cart);
              
        String url = "/admin/invoice.jsp";
        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {
        doGet(request, response);
    }
}