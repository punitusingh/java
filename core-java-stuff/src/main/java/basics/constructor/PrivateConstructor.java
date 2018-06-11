package basics.constructor;

public class PrivateConstructor {


    private PrivateConstructor(){

    }



    private class InnerClass extends PrivateConstructor{
        private static final String className="InnerClass";

        private InnerClass(){

        }

        public PrivateConstructor getPrivateConstructorInstance(){
            return new PrivateConstructor();
        }
    }


    private class AnotherInnerClass extends InnerClass{
        private static final String className="AnotherInnerClass";
        private InnerClass getInnerClassInstance(){
            System.out.println("AnotherInnerClass -> getInnerClassInstance");
            System.out.println(InnerClass.className);
            return new InnerClass();
        }
    }


    private static class StaticInnerClass{
        private static final String className="StaticInnerClass";
    }

    public static void main(String[] args) {
        System.out.println(new PrivateConstructor().new AnotherInnerClass().getInnerClassInstance());
        System.out.println(StaticInnerClass.className);
        System.out.println(AnotherInnerClass.className);
    }

}


