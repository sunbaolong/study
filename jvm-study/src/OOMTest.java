import java.util.ArrayList;
import java.util.List;

/**
 * OurOfMemoryError test
 * Created by sunbaolong on 2017/9/2.
 */
public class OOMTest {

    static class OomObject {}

    public static void main(String[] args) {
        List<OomObject> list = new ArrayList<>();
        while(true) {
            list.add(new OomObject());
        }
    }

}
