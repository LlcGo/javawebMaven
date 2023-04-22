package com.lc.bbs.servlet;

import com.lc.bbs.bean.Address;
import com.lc.bbs.service.AddressService;
import com.lc.bbs.service.impl.AddressServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/4/22
 * @Description
 */
public class AddressController extends HttpServlet {

    AddressService addressService = new AddressServiceimpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String index = req.getParameter("index");
        String count = req.getParameter("count");
        List<Address> addressPage = addressService.getAddressPage(Integer.valueOf(index), Integer.valueOf(count));
        HttpSession session = req.getSession();
        session.setAttribute("addressPage",addressPage);
        resp.sendRedirect("/addressPage.jsp");
    }
}
