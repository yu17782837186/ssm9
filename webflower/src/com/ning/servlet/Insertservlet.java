package com.ning.servlet;

import com.ning.pojo.Flower;
import com.ning.service.FlowerService;
import com.ning.service.impl.FlowerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class Insertservlet extends HttpServlet {
    private FlowerService flowerService = new FlowerServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String production = request.getParameter("production");
        Flower flower = new Flower();
        flower.setName(name);
        flower.setPrice(Double.parseDouble(price));
        flower.setProduction(production);
        int index = flowerService.add(flower);
        if (index > 0) {
            //防止表单重复提交 不能用请求转发
            response.sendRedirect("/webflower/show");
        }else {
            response.sendRedirect("/webflower/add.jsp");
        }
    }
}
