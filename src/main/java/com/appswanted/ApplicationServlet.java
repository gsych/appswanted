package com.appswanted;

import com.appswanted.controllers.IndexController;
import com.appswanted.controllers.PostsController;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.featherj.EntryServlet;
import org.featherj.routes.Route;
import org.featherj.routes.Router;
import org.featherj.routes.UrlParseException;
import org.featherj.routes.params.StringRouteParam;

public class ApplicationServlet extends EntryServlet {

    @Override
    protected Route[] routes() throws UrlParseException {
        return new Route[] {
            Router.route(IndexController.Index, "/"),
            Router.route(PostsController.SearchTags, "/search/tags/:query", new StringRouteParam(":query"))
        };
    }

    public static void main(String[] args) throws Exception{

        com.mchange.v2.c3p0.ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("");

        //Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        Server server = new Server(Integer.valueOf(5000));

        WebAppContext css = new WebAppContext();
        css.setServer(server);
        css.setContextPath("/css");
        css.setWar("target/classes/css");

        WebAppContext js = new WebAppContext();
        js.setServer(server);
        js.setContextPath("/js");
        js.setWar("target/classes/js");

        WebAppContext img = new WebAppContext();
        img.setServer(server);
        img.setContextPath("/img");
        img.setWar("target/classes/img");

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.addServlet(new ServletHolder(new ApplicationServlet()), "/*");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { css, js, img, context });

        server.setHandler(handlers);

        server.start();
        server.join();
    }
}
