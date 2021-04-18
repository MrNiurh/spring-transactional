package me.springtransactional.mapper;

import me.springtransactional.entity.Information;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/4/18
 * @Description
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@Mapper
public interface SpringTransactionalMapper {

    /**
     * 新增一条数据
     *
     * @param info
     * @return void
     */
    void insertOneInformation(Information info);

}
