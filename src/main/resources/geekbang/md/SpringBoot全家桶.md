## SpringBoot全家桶

#### CommandLineRunner
实现这个接口的类会注册到容器中，通过ApplicationContext可以拿到context.getBeansOfType(CommandLineRunner.class)，并调用run
- ConfigurableApplicationContext run(String... args)
    - this.callRunners(context, applicationArguments);
    
