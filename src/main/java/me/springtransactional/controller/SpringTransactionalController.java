package me.springtransactional.controller;

import me.springtransactional.service.serviceImpl.SpringTransactionalServiceImpl;
import me.springtransactional.service.serviceImpl.SpringTransactionalTestsImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: RuiHan.Niu
 * @Date: 2021/4/26
 * @Description:
 */
@RestController
@RequestMapping("/trans")
public class SpringTransactionalController {

    @Resource
    SpringTransactionalTestsImpl springTransactionalTests;

    @Resource
    SpringTransactionalServiceImpl springTransactionalService;

    @PostMapping("/insert")
    public void insertTest() {
        springTransactionalTests.insert();
    }

    @PostMapping("/insert2")
    public void insertTest2() {
        springTransactionalTests.insert2();
    }

    @PostMapping("/call")
    public void callMethodTest() {
        springTransactionalService.callMethodTest();
    }


}
