package basics.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class RunTest {
    public static void main(String[] args) {

        System.out.println("Testing ....");

        int passed=0;
        int failed=0;
        int count=0;
        int ignore=0;

        Class<TestExample> obj=TestExample.class;

        //process @TesterInfo
        if(obj.isAnnotationPresent(TesterInfo.class)){

            Annotation annotation=obj.getAnnotation(TesterInfo.class);
            TesterInfo testerInfo=(TesterInfo)annotation;

            System.out.printf("%n Priority : %s",testerInfo.priority());
            System.out.printf("%n CreatedBy : %s",testerInfo.createdBy());
            System.out.printf("%n Tags :");

            int tagLength=testerInfo.tags().length;
            for(String tag:testerInfo.tags()){
                if(tagLength>1){
                    System.out.print(tag+",");
                }else{
                    System.out.print(tag);
                }
                tagLength--;
            }

            System.out.printf("%n LastModified :%s%n%n",testerInfo.lastModified());
        }



        //process @test
        for(Method method:obj.getDeclaredMethods()){

            //if method is annotated with @Test
            if(method.isAnnotationPresent(Test.class)){

                Annotation annotation=method.getAnnotation(Test.class);
                Test test=(Test)annotation;

                if(test.enabled()){

                    try{
                        method.invoke(obj.newInstance());
                        System.out.printf("%s - Test '%s' - passed %n",++count, method.getName());
                        passed++;
                    }catch (Throwable ex){
                        System.out.printf("%s - Test '%s' - failed : %s %n",++count, method.getName(),ex.getCause());
                        failed++;
                    }


                }else{
                    System.out.printf("%s - Test '%s' - ignored %n",++count, method.getName());
                    ignore++;
                }
            }
        }


        System.out.printf("%n Result : Total : %d, Passed: %d, Failed: %d, Ignore: %d %n",count,passed,failed,ignore);

    }
}
