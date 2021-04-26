package me.springtransactional.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: RuiHan.Niu
 * @Date: 2021/4/26
 * @Description:
 */
@Service
public class SpringTransactionalTestsImpl {

    @Resource
    SpringTransactionalServiceImpl springTransactionalService;

    /**
     * 正常新增 加 requires_new 的回滚测试
     *
     * @param
     * @return void
     */
    @Transactional(rollbackFor = Exception.class)
    public void insert() {
        // 正常新增
        springTransactionalService.insertOneInformation();
        // 传播方式为 requires_new 的错误方法
        springTransactionalService.errorInsert();
    }

    /**
     * 正常新增 加 not_supported 的回滚测试
     *
     * @param
     * @return void
     */
    @Transactional(rollbackFor = Exception.class)
    public void insert2() {
        // 正常新增
        springTransactionalService.insertOneInformation();
        // 传播方式为 not_supported 的错误方法
        springTransactionalService.errorInsert2();
    }

}
