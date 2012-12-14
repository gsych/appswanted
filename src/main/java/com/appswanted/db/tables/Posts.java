package com.appswanted.db.tables;

import java.sql.Timestamp;
import org.featherj.db.DbTable;
import org.featherj.db.Field;

public class Posts extends DbTable<Posts> {

    public static final Posts Posts = new Posts();
    
    public final Field<String> Tags = new Field<String>("tags", this);
    public final Field<String> Content = new Field<String>("content", this);
    public final Field<Timestamp> Ts = new Field<Timestamp>("ts", this);
    public final Field<Integer> Score = new Field<Integer>("score", this);
    public final Field<Integer> UserId = new Field<Integer>("user_id", this);
    public final Field<Integer> PostId = new Field<Integer>("post_id", this);
    public final Field<Integer> ParentId = new Field<Integer>("parent_id", this);
    
    public Posts() {
        super("posts");
    }
    
    public Posts(String alias) {
        super("posts", alias);
    }
    
    @Override
    public Posts as(String alias) {
        return new Posts(alias);
    }
    
}