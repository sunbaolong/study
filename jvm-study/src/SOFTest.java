/**
 * StackOverFlow test
 * Created by sunbaolong on 2017/9/2.
 */
public class SOFTest {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        SOFTest sofTest = new SOFTest();
        sofTest.stackLeak();
    }

}
