package basics.annotation;

@TesterInfo(
        priority = TesterInfo.Priority.HIGH,
        createdBy = "punit",
        tags = {"sales","test"}
)
public class TestExample {

        @Test
        void testA(){
            if(true)
                throw new RuntimeException("this test always failed");
        }


        @Test(enabled = false)
        void testB(){
            if(false)
                 throw new RuntimeException("this test always passed");
        }


        @Test
        void testC(){
            if(10>1){

            }
        }
}

