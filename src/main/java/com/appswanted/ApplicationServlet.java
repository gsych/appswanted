package com.appswanted;

import com.appswanted.controllers.IndexController;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.featherj.EntryServlet;
import org.featherj.routes.Route;
import org.featherj.routes.Router;
import org.featherj.routes.UrlParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationServlet extends EntryServlet {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().print("Hello from Java!\n");
//    }

    @Override
    protected Route[] routes() throws UrlParseException {
        return new Route[] {
            Router.route("/", IndexController.Index)
        };
    }

    public static void main(String[] args) throws Exception{
        //Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        Server server = new Server(Integer.valueOf(5000));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new ApplicationServlet()),"/*");
        server.start();
        server.join();
    }
}
