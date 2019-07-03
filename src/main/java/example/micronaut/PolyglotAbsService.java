package example.micronaut;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.graalvm.polyglot.*;
import org.graalvm.polyglot.proxy.*;

@Singleton 
public class PolyglotAbsService {
   public static String jsAbs(int input){
       try (Context context = Context.create("js")){
           Value jsBindings = context.getBindings("js");
           return ("running abs in JavaScript -> " + jsBindings.getMember("Math").getMember("abs").execute(input));
       }
    }

    public static String pyAbs(int input){
       try (Context context = Context.create("python")){
           Value pyBindings = context.getBindings("python");
           return ("running abs in Python -> " + pyBindings.getMember("abs").execute(input));
       }
    }

    public static String rbAbs(int input){
       try (Context context = Context.create("ruby")){
           return ("running abs in Ruby -> " + context.eval("ruby", input + ".abs"));
       }
    }
}
