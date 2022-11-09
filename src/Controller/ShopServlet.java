package Controller;

import dao.ProductDAO;
import entities.ProductEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shop1")
public class ShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/shop.jsp";

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
