package org.smartlearning.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.smartlearning.aspects")
@EnableAspectJAutoProxy
public class AspectConfig {
}
