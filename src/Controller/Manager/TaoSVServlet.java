package Controller.Manager;

import dao.ProductDAO;
import entities.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "TaoSVServlet", value = "/TaoSVServlet")
public class TaoSVServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String url = "/ViewServlet";
        ProductDAO productDAO = new ProductDAO();
        ProductEntity product = new ProductEntity();
        product.setTitle(request.getParameter("title"));
        product.setPrice(Long.parseLong(request.getParameter("price")));
        product.setSize(request.getParameter("size"));
        product.setColor(request.getParameter("color"));
        product.setDescription(request.getParameter("description"));
        product.setImage(request.getParameter("image"));
        product.setId(0);

        productDAO.insertProduct(product);
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
