package com.nenusoftware.gardenprotector.reply;

import com.nenusoftware.gardenprotector.entity.reply.Reply;
import com.nenusoftware.gardenprotector.service.reply.ReplyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author : kongyy
 * @time : 2019/5/14 20:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyServiceTest {

    @Autowired
    ReplyService replyService;

    @Test
    public void testAddReply() throws Exception{
        Date date = new Date();
        String createtime = String.valueOf(date);
        Reply reply = new Reply();
        reply.setUser_id(1);
        reply.setAuthor("孔一言");
        reply.setReplycomment_id(2);
        reply.setContent("你的评论真棒");
        reply.setLiked(0);
        reply.setCreatetime(createtime);
        replyService.addReply(reply);
    }

    @Test
    public void testListReply() throws Exception{
        System.out.println(replyService.listReply(2));
    }

    @Test
    public void testDelReply() throws Exception{
        int id = 4;
        replyService.delReply(id);
    }

    @Test
    public void testGetReplyLike() throws Exception{
        int id = 3;
        System.out.println(replyService.getReplyLike(id));
    }
}
