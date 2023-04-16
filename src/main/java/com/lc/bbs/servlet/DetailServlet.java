package com.lc.bbs.servlet;

import com.lc.bbs.bean.Detail;
import com.lc.bbs.bean.Sort;
import com.lc.bbs.service.DetailService;
import com.lc.bbs.service.SortService;
import com.lc.bbs.service.impl.DetailserviceImpl;
import com.lc.bbs.service.impl.SortServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/4/16
 * @Description
 */
@WebServlet(name = "detailServlet",value = "/details")
public class DetailServlet extends HttpServlet {

    private SortService sortService = new SortServiceimpl();

    private DetailService detailService = new DetailserviceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //基于反射
        String methodName = req.getParameter("method") == null ? "detailList" : req.getParameter("method");

        try {
            Method method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //基于反射
        String methodName = req.getParameter("method") == null ? "detailList" : req.getParameter("method");

        try {
            Method method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void detailList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //获取查询参数,讨论版区
        String sorId = req.getParameter("sortId") == null ? "0" : req.getParameter("sortId");

        //查询数据库中所有的讨论版区
        List<Sort> allSortList = sortService.getAllSortList();

        List<Detail> detailListById = detailService.getDetailListById(Integer.parseInt(sorId));

        //存入到作用域中
        req.setAttribute("sortList",allSortList);
        req.setAttribute("detailList",detailListById);

        //转发到我们的论坛帖子主页
        req.getRequestDispatcher("bbsList.jsp").forward(req,resp);
    }

    public void toAddDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 查询数据库中，所有的讨论版区，将讨论版区存入到作用域中
        request.setAttribute("sortList", sortService.getAllSortList());

        // 转发到论坛帖子主页
        request.getRequestDispatcher("bbsAdd.jsp").forward(request, response);
    }

    public void addDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 根据表单提交参数，封装帖子详情
        Detail detailForm = new Detail();
        detailForm.setSortId(Integer.valueOf(request.getParameter("sortId")));
        detailForm.setTitle(request.getParameter("title"));
        detailForm.setDetail(request.getParameter("detail"));
        detailForm.setAuthor(request.getParameter("author"));

        // 调用业务接口，增加帖子详情
        detailService.addDetail(detailForm);

        // 重定向到列表请求
        response.sendRedirect("/details");
    }

}
