package com.appswanted.controllers;

import com.appswanted.views.gen.Index;
import org.featherj.Controller;
import org.featherj.Request;
import org.featherj.actions.Action;
import org.featherj.actions.ActionResult;

public class IndexController extends Controller {

    public static Action Index = new Action() {
        @Override
        public ActionResult run(Request request) throws Exception {
            return ok(new Index());
        }
    };
}
