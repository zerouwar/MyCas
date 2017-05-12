package cas.chenhuanming.cn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017-05-12.
 */
public interface CasController {
    void handle(HttpServletRequest request, HttpServletResponse response);
}
