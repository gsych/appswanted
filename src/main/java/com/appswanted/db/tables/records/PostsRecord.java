package com.appswanted.db.tables.records;

import static com.appswanted.db.tables.Posts.Posts;
import org.featherj.db.DbRecord;
import java.sql.Timestamp;

public class PostsRecord extends DbRecord {

    public PostsRecord() {
        super(Posts);
    }
    
    public PostsRecord(DbRecord innerRecord) {
        super(innerRecord);
    }
    
    public String getTags() {
        return getValue(Posts.Tags);
    }
    
    public void setTags(String value) {
        setValue(Posts.Tags, value);
    }
    
    public String getContent() {
        return getValue(Posts.Content);
    }
    
    public void setContent(String value) {
        setValue(Posts.Content, value);
    }
    
    public Timestamp getTs() {
        return getValue(Posts.Ts);
    }
    
    public void setTs(Timestamp value) {
        setValue(Posts.Ts, value);
    }
    
    public String getSubject() {
        return getValue(Posts.Subject);
    }
    
    public void setSubject(String value) {
        setValue(Posts.Subject, value);
    }
    
    public Integer getScore() {
        return getValue(Posts.Score);
    }
    
    public void setScore(Integer value) {
        setValue(Posts.Score, value);
    }
    
    public Integer getUserId() {
        return getValue(Posts.UserId);
    }
    
    public void setUserId(Integer value) {
        setValue(Posts.UserId, value);
    }
    
    public Integer getPostId() {
        return getValue(Posts.PostId);
    }
    
    public void setPostId(Integer value) {
        setValue(Posts.PostId, value);
    }
    
    public Integer getParentId() {
        return getValue(Posts.ParentId);
    }
    
    public void setParentId(Integer value) {
        setValue(Posts.ParentId, value);
    }
    
}