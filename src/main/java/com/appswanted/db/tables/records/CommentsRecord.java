package com.appswanted.db.tables.records;

import static com.appswanted.db.tables.Comments.Comments;
import org.featherj.db.DbRecord;
import java.sql.Timestamp;

public class CommentsRecord extends DbRecord {

    public CommentsRecord() {
        super(Comments);
    }
    
    public CommentsRecord(DbRecord innerRecord) {
        super(innerRecord);
    }
    
    public Integer getCommentId() {
        return getValue(Comments.CommentId);
    }
    
    public void setCommentId(Integer value) {
        setValue(Comments.CommentId, value);
    }
    
    public Timestamp getTs() {
        return getValue(Comments.Ts);
    }
    
    public void setTs(Timestamp value) {
        setValue(Comments.Ts, value);
    }
    
    public Integer getScore() {
        return getValue(Comments.Score);
    }
    
    public void setScore(Integer value) {
        setValue(Comments.Score, value);
    }
    
    public Integer getUserId() {
        return getValue(Comments.UserId);
    }
    
    public void setUserId(Integer value) {
        setValue(Comments.UserId, value);
    }
    
    public String getComment() {
        return getValue(Comments.Comment);
    }
    
    public void setComment(String value) {
        setValue(Comments.Comment, value);
    }
    
    public Integer getPostId() {
        return getValue(Comments.PostId);
    }
    
    public void setPostId(Integer value) {
        setValue(Comments.PostId, value);
    }
    
}