package javacorecourse.task_19;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Home on 3/27/2015.
 */
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface Parameters {
    int count() default 1;
    enum parametersTYPE{STRING, INT}
    parametersTYPE type() default parametersTYPE.STRING;
}