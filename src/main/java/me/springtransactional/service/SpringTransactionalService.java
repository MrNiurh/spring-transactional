package me.springtransactional.service;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/4/18
 * @Description
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public interface SpringTransactionalService {

    /**
     * 新增一条信息
     *
     * @return void
     */
    void insertOneInformation();

    /**
     * 错误新增
     *
     * @return void
     */
    void errorInsert();

    /**
     * 同一个类中的事务相互调用
     *
     * @return void
     */
    void callMethodTest();

    /**
     * 错误新增
     * propagation = Propagation.REQUIRES_NEW
     *
     * @return void
     */
    void requiresNewTest();
}
