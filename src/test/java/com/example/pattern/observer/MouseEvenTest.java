package com.example.pattern.observer;
import com.example.pattern.observer.events.Event;
import com.example.pattern.observer.events.Mouse;
import com.example.pattern.observer.events.MouseEvenCallback;
import com.example.pattern.observer.events.MouseEvents;
import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/28 4:47 下午
 * @since V1.0.0
 */
public class MouseEvenTest {

    @Test
    public void test() throws Exception {
        Mouse mouse = new Mouse();
        MouseEvenCallback mouseEvenCallback = new MouseEvenCallback();
        mouse.addListener(MouseEvents.CLICK, mouseEvenCallback);
        mouse.addListener(MouseEvents.DOUBLE_CLICK, mouseEvenCallback);
        mouse.click();
        mouse.doubleClick();
    }

}
