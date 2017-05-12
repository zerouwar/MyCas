package cas.chenhuanming.cn;

import cas.chenhuanming.cn.authentication.AuthenticationManager;
import cas.chenhuanming.cn.authentication.AuthenticationProvider;
import cas.chenhuanming.cn.authentication.DaoAuthenticationProvider;
import cas.chenhuanming.cn.authentication.ProviderManager;
import cas.chenhuanming.cn.controller.CasController;
import cas.chenhuanming.cn.controller.StandardCasController;
import cas.chenhuanming.cn.ticket.SimpleTicketManager;
import cas.chenhuanming.cn.ticket.TicketManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017-05-12.
 */
@WebServlet("/")
public class MainServlet extends HttpServlet{
    private CasController casController;

    public MainServlet() {
        AuthenticationProvider provider = new DaoAuthenticationProvider();
        TicketManager ticketManager = new SimpleTicketManager();
        AuthenticationManager authenticationManager = new ProviderManager(provider);
        casController = new StandardCasController(ticketManager,authenticationManager);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        casController.handle(request,response);
    }
}
