package com.appswanted;

import com.appswanted.controllers.IndexController;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.featherj.EntryServlet;
import org.featherj.routes.Route;
import org.featherj.routes.Router;
import org.featherj.routes.UrlParseException;

public class ApplicationServlet extends EntryServlet {

    @Override
    protected Route[] routes() throws UrlParseException {
        return new Route[] {
            Router.route("/", IndexController.Index),
            Router.resourceRoute("/css/*")
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
