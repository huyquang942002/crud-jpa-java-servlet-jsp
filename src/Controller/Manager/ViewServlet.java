package Controller.Manager;

import dao.ProductDAO;
import entities.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewServlet", value = "/ViewServlet1")
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/manager/index.jsp";

        List<ProductEntity> products = new ArrayList<>();
        ProductDAO productDAO = new ProductDAO();
        products = productDAO.getListProduct();
        for(ProductEntity product : products) {
            System.out.println(product);
        }
        request.setAttribute("productList",products);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
