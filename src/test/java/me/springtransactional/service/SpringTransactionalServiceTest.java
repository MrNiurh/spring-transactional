package me.springtransactional.service;

import me.springtransactional.mapper.SpringTransactionalMapper;
import me.springtransactional.service.serviceImpl.SpringTransactionalServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: RuiHan.Niu
 * @Date: 2021/4/26
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringTransactionalServiceTest {

    @Resource
    SpringTransactionalServiceImpl springTransactionalService;

    @Resource
    SpringTransactionalMapper springTransactionalMapper;

    /**
     * 正常新增
     *
     * @param
     * @return void
     */
    @Test
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Commit
    public void rightTest() {
        springTransactionalService.insertOneInformation();
    }

    /**
     * 回滚测试
     *
     * @param
     * @return void
     */
    @Test
    @Transactional(rollbackFor = Exception.class)
    @Commit
    public void transactionalTest() {
        springTransactionalService.insertOneInformation();
        springTransactionalService.errorInsert2();
    }

    /**
     * 在类A里面有方法a 和方法b， 然后方法b上面用 @Transactional加了方法级别的事务，在方法a里面 调用了方法b，
     * 方法b里面的事务不会生效。原因是在同一个类之中，方法互相调用，切面无效 ，而不仅仅是事务。
     * 这里事务之所以无效，是因为spring的事务是通过aop实现的。
     *
     * @param
     * @return void
     */
    @Test
    public void callMethodTest() {
        springTransactionalService.callMethodTest();
    }

    /**
     * 如果A有事务，将A的事务挂起，B创建一个新的事务；如果A没有事务，B创建一个新的事务。
     *
     * @param
     * @return void
     */
    @Test
    @Transactional(rollbackFor = Exception.class)
    @Commit
    public void requiresNewTest() {
        springTransactionalService.insertOneInformation();
        springTransactionalService.requiresNewTest();
    }

}
