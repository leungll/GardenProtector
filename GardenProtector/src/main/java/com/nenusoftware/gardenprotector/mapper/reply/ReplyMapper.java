package com.nenusoftware.gardenprotector.mapper.reply;

import com.nenusoftware.gardenprotector.entity.reply.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/14 18:36
 */
@Mapper
@Repository
public interface ReplyMapper {

    public boolean addReply(@Param("reply") Reply reply) throws Exception;

    public boolean delReply(@Param("id") int id) throws Exception;

    //public boolean updateReplt(@Param("reply") Reply reply) throws Exception;

    public boolean giveLike(@Param("id") int id, @Param("replycomment_id") int replycomment_id) throws Exception;

    public List<Reply> listReply(@Param("replycomment_id") int replycomment_id) throws Exception;

    public List<Reply> getReplyLike (@Param("id") int id) throws Exception;
}
