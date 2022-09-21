package cn.proxy.controller;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-21 11:16
 * @modified By:
 */
public class ThirdTestClassServiceImpl  implements MainTestClassService, SecondTestClassService {

    //@Override
    //public void MainHelloTest() {
    //    System.out.println("你好，我是小明");
    //}
    //
    //@Override
    //public void MainHelloTest2() {
    //    System.out.println("你好，我是小明2号");
    //}

    @Override
    public void HelloTest() {
        System.out.println("你好，我是小明3号");
    }

    //@Override
    //public void HelloTest2() {
    //    System.out.println("你好，我是小明3号");
    //}
}

