package com.lkf.jvm;

/**
 * 此代码演示了两点：
 * 一是：对象可以被GC自我救赎
 * 二是：这种自我救赎的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
 **/
public class FinalizeEscapeGCDemo {
    public static FinalizeEscapeGCDemo SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("Yes,I'm still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGCDemo.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGCDemo();

        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No,I'm dead :)");
        }

        //下面这段代码与上面的完全相同，但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No,I'm dead :)");
        }
    }
}
