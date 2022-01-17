package com.beniregev.d_methodreference;

import java.util.Arrays;
import java.util.List;

/**
 * <div>
 *     <p>
 *         <ul>Demonstrating Java 8 Method Reference.
 *             <li>Simple Method Reference -- Println</li>
 *             <li>How it was before Java 8 -- Method Reference of My Own Implementation</li>
 *             <li>Java 8 No Method Reference Anonymous Inner Class.</li>
 *             <li>Java 8 static and non-static Method Reference of Own Implementation.</li>
 *         </ul>
 *     </p>
 * </div>
 * @author Binyamin Regev
 * @since 1.8.0_162
 */
public class Java8MethodReferenceExample {
    private List<String> names = Arrays.asList("Avraham", "Sarah", "Izik", "Rivka", "Jakob", "Lea", "Rachel");

    /**
     * <div>
     *     <p>With Java 8 Method Reference {@code System.out.println}</p>
     *     <p>
     *         <div>
     *             In Java 8 we can pass a method as an argument to a method. But
     *             we need to tell that it's a method we are sending, we do that
     *             with 2 colons "::".
     *         </div>
     *         <pre>
     *             <code>
     *     names.forEach(::println);
     *             </code>
     *         </pre>
     *     </p>
     *     <p>
     *         <div>And we need to tell where the method is located:</div>
     *         <pre>
     *             <code>
     *     names.forEach(System.out::println);
     *             </code>
     *         </pre>
     *     </p>
     *     <p>
     *         <h4>And We Are Done!</h4>
     *     </p>
     * </div>
     */
    public void java8MethodReferencePrintln() {
        System.out.println("java8MethodReferencePrintln():");
        names.forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    /**
     * Before Java 8, using method reference with my own implementation
     */
    public void beforeJava8MethodReferenceWithMyOwnImplementation() {
        System.out.println("beforeJava8CallingMethodReferenceWithMyOwnImplementation(): ");

        String str = "\t\tClearing Pluggability";
        MyPrinter mp = new MyPrinter();
        mp.print(str);
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    /**
     * With Java 8, no method reference anonymous inner-class
     */
    public void java8NoMethodReferenceAnonymousInnerClass() {
        System.out.println("java8NoMethodReferenceAnonymousInnerClass(): ");

        MyPrinter mp = new MyPrinter();
        mp.print("\t\tP2go", new Parser() {
            @Override
            public String parse(String str) {
                return StringParser.staticConvert(str);
            }
        });
        mp.print("\t\tP2Go-Onboarding", new Parser() {
            @Override
            public String parse(String str) {
                return StringParser.staticConvert(str);
            }
        });
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    /**
     * With Java 8, using method reference with my own implementation
     */
    public void java8MethodReferenceWithOwnImplementation() {
        System.out.println("java8MethodReferenceWithOwnImplementation(): ");

        MyPrinter mp = new MyPrinter();
        //  Lambda
        System.out.println("\tCalling a static method using Lambda");
        mp.print("\t\tP2go", (str -> StringParser.staticConvert(str)));
        mp.print("\t\tClearing Pluggability", (str -> StringParser.staticConvert(str)));

        //  Method Reference - calling a static method
        System.out.println("\tMethod Reference - calling a static method");
        mp.print("\t\tFinastra", (StringParser::staticConvert));
        mp.print("\t\tp2go", (StringParser::staticConvert));

        //  Method Reference - calling a non-static method
        System.out.println("\tMethod Reference - calling a non-static method");
        StringParser sp = new StringParser();
        mp.print("\t\tFinastra", (sp::nonStaticConvert));
        mp.print("\t\tClearing Pluggability", (sp::nonStaticConvert));

        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Java8MethodReferenceExample example = new Java8MethodReferenceExample();

        example.java8MethodReferencePrintln();
        example.beforeJava8MethodReferenceWithMyOwnImplementation();
        example.java8NoMethodReferenceAnonymousInnerClass();
        example.java8MethodReferenceWithOwnImplementation();
    }
}

/**
 *
 * @author Binyamin Regev
 * @since 1.8
 */
class MyPrinter {
    public void print(String str) {
        System.out.println(str);
    }
    public void print(String str, Parser p) {
        str = p.parse(str);
        System.out.println(str);
    }
}

/**
 *
 * @author Binyamin Regev
 * @since 1.8
 */
interface Parser {
    String parse(String str);
}

/**
 *
 * @author Binyamin Regev
 * @since 1.8
 */
class StringParser {
    public static String staticConvert(String s) {
        if (s.length() <= 6)
            s = s.toUpperCase();
        else
            s = s.toLowerCase();
        return s;
    }

    public String nonStaticConvert(String s) {
        if (s.length() > 12)
            s = s.toUpperCase();
        else
            s = s.toLowerCase();
        return s;
    }
}