package com.example.curefitfeed;

import com.example.curefitfeed.model.Food;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest extends TestCase {
    Food food = new Food();
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

}