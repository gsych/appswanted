package com.appswanted.db.tables;

import java.sql.Timestamp;
import org.featherj.db.DbTable;
import org.featherj.db.Field;

public class Users extends DbTable<Users> {

    public static final Users Users = new Users();
    
    public final Field<String> DisplayName = new Field<String>("display_name", this);
    public final Field<Timestamp> Ts = new Field<Timestamp>("ts", this);
    public final Field<Character> Status = new Field<Character>("status", this);
    public final Field<Timestamp> RegisterDate = new Field<Timestamp>("register_date", this);
    public final Field<String> Email = new Field<String>("email", this);
    public final Field<Integer> Activated = new Field<Integer>("activated", this);
    public final Field<Integer> UserId = new Field<Integer>("user_id", this);
    public final Field<String> ActivationCode = new Field<String>("activation_code", this);
    
    public Users() {
        super("users");
    }
    
    public Users(String alias) {
        super("users", alias);
    }
    
    @Override
    public Users as(String alias) {
        return new Users(alias);
    }
    
}