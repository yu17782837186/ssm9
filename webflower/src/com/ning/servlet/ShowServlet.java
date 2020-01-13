package com.ning.servlet;

import com.ning.pojo.Flower;
import com.ning.service.FlowerService;
import com.ning.service.impl.FlowerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowServlet extends HttpServlet {
    private FlowerService flowerService = new FlowerServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<Flower> list = flowerService.show();
        request.setAttribute("list",list);
        request.getRequestDispatcher("index2.jsp").forward(request,response);
    }
}
