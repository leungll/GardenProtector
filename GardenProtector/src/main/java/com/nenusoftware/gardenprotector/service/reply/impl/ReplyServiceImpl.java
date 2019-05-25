package com.nenusoftware.gardenprotector.service.reply.impl;

import com.nenusoftware.gardenprotector.entity.reply.Reply;
import com.nenusoftware.gardenprotector.mapper.reply.ReplyMapper;
import com.nenusoftware.gardenprotector.service.reply.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/14 18:54
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public boolean addReply(Reply reply) throws Exception{
        return replyMapper.addReply(reply);
    }

    @Override
    public boolean delReply(int id) throws Exception{
        return replyMapper.delReply(id);
    }

//    @Override
//    public boolean updateReply(Reply reply) throws Exception{
//        return replyMapper.updateReplt(reply);
//    }

    @Override
    public List<Reply> listReply(int replycomment_id) throws Exception{
        List<Reply> list = Collections.emptyList();
        list = replyMapper.listReply(replycomment_id);
        return list;
    }

    @Override
    public boolean giveLike(int id, int replycomment_id) throws Exception{
        return replyMapper.giveLike(id, replycomment_id);
    }

    @Override
    public List<Reply> getReplyLike(int id) throws Exception{
        List<Reply> list = Collections.emptyList();
        list = replyMapper.getReplyLike(id);
        return list;
    }
}
