package com.nenusoftware.gardenprotector.service.reply;

import com.nenusoftware.gardenprotector.entity.reply.Reply;

import java.util.List;
import java.util.Random;

/**
 * @author : kongyy
 * @time : 2019/5/14 18:51
 */
public interface ReplyService {

    public boolean addReply(Reply reply) throws Exception;

    public boolean delReply(int id) throws Exception;

    //public boolean updateReply(Reply reply) throws Exception;

    public List<Reply> listReply(int replycomment_id) throws Exception;

    public boolean giveLike(int id, int replycomment_id) throws Exception;

    public List<Reply> getReplyLike(int id) throws Exception;
}
