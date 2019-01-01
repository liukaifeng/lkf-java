package com.lkf.parttern.decorator;

/**
 * 抽象装饰器
 *
 * @author kaifeng
 * @date 2018/12/31
 */
public abstract class Decorator implements Component {
    protected Component component;

    public void SetComponent(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        if (component != null) {
            component.operation();
        }
    }
}
