package main;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
public class MockBehaviour {
    public static void main(String[] args) {
        // behaviour();
        // stubbing();
        argumentMatchers();
    }

    private static void behaviour() {
        //mock creation
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    static void stubbing() {
        //You can mock concrete classes, not just interfaces
        var mockedList = mock(LinkedList.class);

        //stubbing
        when(mockedList.get(0)).thenReturn("first");
//        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));

        //following throws runtime exception
        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        //If your code doesn't care what get(0) returns, then it should not be stubbed.
        verify(mockedList).get(0);

        // stubbing void methods with exceptions
        doThrow(new RuntimeException()).when(mockedList).clear();

        //following throws RuntimeException:
        mockedList.clear();
    }

    static void argumentMatchers() {
        var mockedList = mock(LinkedList.class);
        when(mockedList.get(anyInt())).thenReturn("element");
        when(mockedList.contains(argThat(MockBehaviour::isValid))).thenReturn(true);
        //following prints "element"
        System.out.println(mockedList.get(999));
        System.out.println(mockedList.contains("aaaaaa"));
        System.out.println(mockedList.contains("aaa"));

        //you can also verify using an argument matcher
        verify(mockedList).get(anyInt());
        verify(mockedList).contains(argThat(MockBehaviour::isValid));

        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //following two verifications work exactly the same - times(1) is used by default
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //exact number of invocations verification
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        verify(mockedList, never()).add("never happened");

        //verification using atLeast()/atMost()
        verify(mockedList, atMostOnce()).add("once");
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");
    }

    static boolean isValid(String a) {
        return a.length() > 5;
    }
}