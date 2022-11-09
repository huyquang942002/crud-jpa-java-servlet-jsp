package Controller.Manager;

import dao.ProductDAO;
import entities.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet1")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String masv = request.getParameter("masv");
//        ProductDAO dao = new ProductDAO();
//        System.out.println(masv);
//        ProductEntity product = dao.getByMaSv(masv);
//        request.setAttribute("product", product);
//        request.getRequestDispatcher("updateProduct.jsp")
//                .forward(request, response);
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String url = "/ViewServlet1";
        ProductDAO ProductDAO = new ProductDAO();
        ProductEntity product = new ProductEntity();
        product.setId(Long.parseLong(request.getParameter("id")));
        product.setTitle(request.getParameter("title"));
        /*boolean phai = true;
        if (request.getParameter("phai").equals(false)) {
            phai = false;
        }*/

        product.setPrice(Long.parseLong(request.getParameter("price")));
        /*Date date;
        if (request.getParameter("birthday")!=null) {
            date = Util.stringToDate(request.getParameter("birthday"));
            product.setBirthday(date);
        }*/
        product.setSize(request.getParameter("size"));
        product.setColor(request.getParameter("color"));
        product.setDescription(request.getParameter("description"));
        product.setImage(request.getParameter("image"));


        ProductDAO.updateProduct(product);
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        //response.sendRedirect("/ViewServlet");
    }
}
