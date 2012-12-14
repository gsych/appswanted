package com.appswanted.db.tables;

import java.sql.Timestamp;
import org.featherj.db.DbTable;
import org.featherj.db.Field;

public class Comments extends DbTable<Comments> {

    public static final Comments Comments = new Comments();
    
    public final Field<Integer> CommentId = new Field<Integer>("comment_id", this);
    public final Field<Timestamp> Ts = new Field<Timestamp>("ts", this);
    public final Field<Integer> Score = new Field<Integer>("score", this);
    public final Field<Integer> UserId = new Field<Integer>("user_id", this);
    public final Field<String> Comment = new Field<String>("comment", this);
    public final Field<Integer> PostId = new Field<Integer>("post_id", this);
    
    public Comments() {
        super("comments");
    }
    
    public Comments(String alias) {
        super("comments", alias);
    }
    
    @Override
    public Comments as(String alias) {
        return new Comments(alias);
    }
    
}