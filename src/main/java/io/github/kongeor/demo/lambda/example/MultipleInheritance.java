package io.github.kongeor.demo.lambda.example;

interface Foo {
    default void baz() {
        System.out.println("Foo::baz");
    }
}

interface Bar {
    default void baz() {
        System.out.println("Bar::baz");
    }
}

class Qux implements Foo, Bar {
    @Override
    public void baz() {
        System.out.println("Qux::baz");
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        new Qux().baz();
    }
}
