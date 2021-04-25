package me.springtransactional.service.serviceImpl;

import me.springtransactional.entity.Information;
import me.springtransactional.mapper.SpringTransactionalMapper;
import me.springtransactional.service.SpringTransactionalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/4/18
 * @Description
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@Service
public class SpringTransactionalServiceImpl implements SpringTransactionalService {

    @Resource
    SpringTransactionalMapper springTransactionalMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertOneInformation() {
        springTransactionalMapper.insertOneInformation(new Information("正常新增测试"));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void errorInsert() {
        springTransactionalMapper.insertOneInformation(new Information("错误新增测试"));

        int a = 1 / 0;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public void errorInsert2() {
        springTransactionalMapper.insertOneInformation(new Information("错误新增测试2"));
        int a = 1 / 0;
    }

    @Override
    public void callMethodTest() {
        insertOneInformation();
        errorInsert();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void requiresNewTest() {
        springTransactionalMapper.insertOneInformation(new Information("错误新增测试"));
        int a = 1 / 0;
    }


}
