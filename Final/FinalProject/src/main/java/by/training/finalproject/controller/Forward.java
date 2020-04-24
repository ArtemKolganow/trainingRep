package by.training.finalproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Forward {
    private boolean isRedirect;
    private String url;

    public Forward(boolean isRedirect, String url) {
        this.isRedirect = isRedirect;
        this.url = url;
    }

    public Forward() {
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(isRedirect){
           response.sendRedirect(url);
        }else{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}
