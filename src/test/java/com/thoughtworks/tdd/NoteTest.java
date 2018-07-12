package com.thoughtworks.tdd;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoteTest {
    @Test
    public void should_return_1_when_call_getNo_init_1(){
        Note note = new Note(1);

        int result = note.getNo();

        assertEquals(1, result);
        assertEquals(note, new Note(1));
    }

    @Test
    public void should_return_true_when_call_equals_input_two_notes_with_same_no(){
        Note note = new Note(1);
        Note note2 = new Note(1);

        boolean result = note.equals(note2);

        assertTrue(result);
    }
}
