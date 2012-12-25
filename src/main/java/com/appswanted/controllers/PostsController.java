package com.appswanted.controllers;

import static com.appswanted.db.tables.Posts.Posts;

import com.appswanted.Ds;
import com.appswanted.db.tables.records.PostsRecord;
import com.appswanted.views.gen.SearchTagsResult;
import org.apache.commons.lang.StringUtils;
import org.featherj.Controller;
import org.featherj.Request;
import org.featherj.View;
import org.featherj.actions.Action;
import org.featherj.actions.ActionResult;
import org.featherj.db.DbRecord;
import org.featherj.db.queries.SelectQuery;
import org.featherj.db.queries.expr.QueryBoolExpr;

import java.util.ArrayList;
import java.util.List;

public class PostsController extends Controller {

    public static Action SearchTags = new Action() {
        @Override
        public ActionResult run(Request request) throws Exception {
            String searchQuery = request.param(":query");
            String[] words = searchQuery.split("\\s+");

            SelectQuery query = new SelectQuery().select().from(Posts).getQuery();

            for (String word : words) {
                QueryBoolExpr expr = query.getWhere();
                if (expr == null) {
                    expr = Posts.Tags.like("%" + word + "%");
                }
                else {
                    expr = expr.or(Posts.Tags.like("%" + word + "%"));
                }
                query.setWhere(expr);
            }

            List<DbRecord> records = query.getStatement(Ds.getConnection()).executeQuery().getRecords();

            //FIXME: provide a better implementation using record factory passed to getRecords
            List<PostsRecord> posts = new ArrayList<PostsRecord>();
            for (DbRecord rec : records) {
                posts.add(new PostsRecord(rec));
            }

            SearchTagsResult v = new SearchTagsResult(posts, StringUtils.join(words, ' '));
            v.headJs("/js/common/search-form.js");

            return ok(v);
        }
    };
}
