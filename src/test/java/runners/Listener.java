package runners;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

import java.util.Date;

public class Listener extends RunListener {


    @Override
    public void testRunStarted(Description description) throws Exception {
        Date date = new Date();
        System.out.println("Test started on: " + date);
        System.out.println("Test cases to executes: " + description.testCount());
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("Test cases executed: " + result.getRunCount());
    }
}
