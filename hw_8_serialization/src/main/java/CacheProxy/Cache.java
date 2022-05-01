package CacheProxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    CacheType cacheType() default CacheType.FILE;
    String fileNamePrefix() default "default";
    boolean zip() default false;
    Class[] identityBy() default {};
    long listList() default 0L;
}
