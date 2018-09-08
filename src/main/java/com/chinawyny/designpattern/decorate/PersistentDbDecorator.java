package com.chinawyny.designpattern.decorate;

//被装饰者接口
interface IPersistentUtil {
    
    void persistentMsg(String msg);
    
}

//具体的被装饰者
class PersistentUtil implements IPersistentUtil {
    
    @Override
    public void persistentMsg(String msg) {
        System.out.println(msg + " 存入文件");
    }
    
}

//装饰
abstract class PersistentDecorator implements IPersistentUtil {
    
    IPersistentUtil iPersistentUtil;
    
    public PersistentDecorator(IPersistentUtil iPersistentUtil) {
        this.iPersistentUtil = iPersistentUtil;
    }
    
    @Override
    public void persistentMsg(String msg) {
        iPersistentUtil.persistentMsg(msg);
    }
}


/**
 * 装饰器模式
 * <p>
 * 添加一个装饰器，可以同时实现数据持久化到数据库（具体装饰）
 * <p>
 * 使用了装饰器的对象，功能已经增强了，而且可以使用多个装饰器。
 * <p>
 * java中Reader相当于抽象的被装饰者，FileReader相当于具体的被装饰者，BufferedReader相当于装饰
 */
public class PersistentDbDecorator extends PersistentDecorator {
    
    public PersistentDbDecorator(IPersistentUtil iPersistentUtil) {
        super(iPersistentUtil);
    }
    
    @Override
    public void persistentMsg(String msg) {
        iPersistentUtil.persistentMsg(msg);
        persistentToDb(msg);
    }
    
    private void persistentToDb(String msg) {
        System.out.println(msg + " 存入数据库");
    }
}


