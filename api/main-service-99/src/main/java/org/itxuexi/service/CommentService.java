package org.itxuexi.service;

import org.itxuexi.pojo.bo.CommentBO;
import org.itxuexi.pojo.vo.CommentVO;
import java.util.List;

public interface CommentService {

    /**
     * 创建发表评论
     * @param commentBO
     */
    public CommentVO createComment(CommentBO commentBO);

    /**
     * 查询朋友圈的列表
     * @param friendCircleId
     * @return
     */
    public List<CommentVO> queryAll(String friendCircleId);

    /**
     * 删除朋友圈的评论
     * @param commentUserId
     * @param commentId
     * @param friendCircleId
     */
    public void deleteComment(String commentUserId,
                              String commentId,
                              String friendCircleId);

}
