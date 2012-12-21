package com.appswanted.controllers;

import static com.appswanted.db.tables.Posts.Posts;

import com.appswanted.Ds;
import org.featherj.Controller;
import org.featherj.Request;
import org.featherj.actions.Action;
import org.featherj.actions.ActionResult;
import org.featherj.db.DbRecord;
import org.featherj.db.queries.SelectQuery;

import java.util.List;

public class PostsController extends Controller {

    public static Action SearchTags = new Action() {
        @Override
        public ActionResult run(Request request) throws Exception {
            String searchQuery = request.param("q");
            String[] words = searchQuery.split("\\s*");

            SelectQuery query = new SelectQuery().select().from(Posts).getQuery();

            for (String word : words) {
                query.getFromPart().getRemainderPart()
                    .where(Posts.Tags.like("%" + word + "%"));
            }

            List<DbRecord> records = query.getStatement(Ds.getConnection()).executeQuery().getRecords();
            //result.getI

            return null;
        }
    };
}
