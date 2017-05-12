package cas.chenhuanming.cn.controller;

import cas.chenhuanming.cn.authentication.Authentication;
import cas.chenhuanming.cn.authentication.AuthenticationManager;
import cas.chenhuanming.cn.authentication.PreAuthenticateAuthentication;
import cas.chenhuanming.cn.authentication.exception.AuthenticationException;
import cas.chenhuanming.cn.authentication.exception.ExceptionCode;
import cas.chenhuanming.cn.ticket.Ticket;
import cas.chenhuanming.cn.ticket.SimpleTicketManager;
import cas.chenhuanming.cn.ticket.TicketManager;
import cas.chenhuanming.cn.util.config.PropertiesUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Administrator on 2017-05-12.
 */
public class StandardCasController implements CasController{
    private final TicketManager ticketManager;
    private final AuthenticationManager authenticationManager;
    private final String TICKET_NAME;
    private final String USERNAME;
    private final String PASSWORD;

    public StandardCasController(TicketManager ticketManager, AuthenticationManager authenticationManager) {
        this.ticketManager = ticketManager;
        this.authenticationManager = authenticationManager;
        TICKET_NAME = PropertiesUtil.getProperty("ticketName");
        USERNAME = PropertiesUtil.getProperty("username");
        PASSWORD = PropertiesUtil.getProperty("password");
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) {
        String ticketID = request.getParameter(TICKET_NAME);
        //检验ticket
        if(ticketID!=null){
            Optional<Ticket> optional = ticketManager.getTicket(ticketID);
            if(optional.isPresent()){
                Ticket t = optional.get();
                success(response,t.getUsername());
                return;
            }
        }else{
            String username = request.getParameter(USERNAME);
            String password = request.getParameter(PASSWORD);
            if(username==null||password==null||username.equals("")||password.equals("")){
                wrongRequest(response);
                return;
            }else{
                try {
                    Authentication authentication = authenticationManager.authenticate(new PreAuthenticateAuthentication(username,password));
                    Ticket ticket = new Ticket(UUID.randomUUID().toString(),authentication.getPrincipal().toString(), LocalDateTime.now(),LocalDateTime.now().plusHours(2));
                    ticketManager.addTicket(ticket);
                    success(response,ticket);
                } catch (AuthenticationException e) {
                    fail(response,username,e);
                } catch (Exception e){
                    error(response,ExceptionCode.INTERNAL_ERROR);
                }

            }
        }
    }

    public void success(HttpServletResponse response,String username){
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode node = objectMapper.createObjectNode().put(USERNAME,username).put("status",1);
        try {
            objectMapper.writeValue(response.getOutputStream(),node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void success(HttpServletResponse response,Ticket ticket){
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode node = objectMapper.createObjectNode().put(USERNAME,ticket.getUsername()).put(TICKET_NAME,ticket.getId());
        try {
            objectMapper.writeValue(response.getOutputStream(),node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fail(HttpServletResponse response,String username,AuthenticationException exception){
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode node = objectMapper.createObjectNode()
                .put(USERNAME,username)
                .put("status",0)
                .put("cause",exception.getCode().name())
                .put("error",exception.getMessage());
        try {
            objectMapper.writeValue(response.getOutputStream(),node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wrongRequest(HttpServletResponse response){
        response.setStatus(400);
        try {
            response.getWriter().write("错误的请求！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void error(HttpServletResponse response, ExceptionCode code){
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode node = objectMapper.createObjectNode()
                .put("status",0)
                .put("cause",code.name());
        try {
            objectMapper.writeValue(response.getOutputStream(),node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
