package Controller.Manager;

import dao.ProductDAO;
import entities.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DetailServlet", value = "/DetailServlet1")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/manager/detail.jsp";

        ProductEntity product = new ProductEntity();
        Integer productId = Integer.parseInt(request.getParameter("id"));
        ProductDAO productDAO = new ProductDAO();
        product = productDAO.getProductById(productId);

        request.setAttribute("o",product);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
