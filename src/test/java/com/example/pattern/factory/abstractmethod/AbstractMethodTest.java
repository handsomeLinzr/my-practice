package com.example.pattern.factory.abstractmethod;

import com.example.pattern.factory.abstractfactory.*;
import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/27 4:46 下午
 * @since V1.0.0
 */
public class AbstractMethodTest {

    @Test
    public void createNote() {
        IFactory javaFactory = new JavaFactory();
        INote javaNote = javaFactory.createNote();
        javaNote.edit();

        IVideo javaVideo = javaFactory.createVideo();
        javaVideo.play();

        IFactory pythonFactory = new PythonFactory();
        INote pythonNote = pythonFactory.createNote();
        pythonNote.edit();

        IVideo pythonVideo = pythonFactory.createVideo();
        pythonVideo.play();

    }

}
