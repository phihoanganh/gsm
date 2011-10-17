/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 import javax.servlet.http.HttpSession;

import BUS.ManufacturerBUS;
import BUS.ProductBUS;
import BUS.ProductPhotoBUS;
import POJO.Manufacturer;
import POJO.Productphotos;
import POJO.Products;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ultimate
 */
@WebServlet(name = "productDetailAdminController", urlPatterns = {"/productDetailAdminController"})
public class productDetailAdminController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet productDetailAdminController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet productDetailAdminController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        	ServletContext app=getServletContext();;
        	String lang=(String)app.getAttribute("MALL_LA");
        	
            String productId = request.getParameter("Id");
            Products pr = ProductBUS.getProducts(Integer.parseInt(productId),lang);
            request.setAttribute("productPOJO", pr);

            Productphotos photo = ProductPhotoBUS.lstProductPhoto(pr,lang);
            request.setAttribute("productPhotoPOJO", photo);

            List<Productphotos> lstPhoto = ProductPhotoBUS.lstProductPhotoAll(pr,lang);
            request.setAttribute("productPhotoPOJOs", lstPhoto);

            Manufacturer ma = ManufacturerBUS.getManufacturer(pr.getManufacturerId(),lang);
            request.setAttribute("manufacturerPOJO", ma);

            String url = "/admin/productdetail.html";
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(url);
            rd.forward(request, response);
           // session.setAttribute("lastpage", "productdetail.html?Id=" + productId);
        } catch (Exception ex) {
            out.println(ex.getMessage());

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
