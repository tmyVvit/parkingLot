package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BaseControllerTest {
    @Test
    public void should_return_different_currentPage_when_call_docommand_given_different_request(){
    // given
        Request request = mock(Request.class);
        Response response = mock(Response.class);
        BaseController baseController = new BaseController(response);
        when(request.getCommand()).thenReturn("1","2", "asd");
    // when;

        String result1 = baseController.doCommand(request);
        String result2 = baseController.doCommand(request);
        String result3 = baseController.doCommand(request);
        // then
        assertEquals("main", result1);
        assertEquals("parkManage", result2);
        verify(response).print("非法指令，请查证后再输\n");
    }

    @Test
    public void should_return_base_page_when_call_printPage(){
    // given
        Request request = mock(Request.class);
        Response response = mock(Response.class);
        BaseController baseController = new BaseController(response);
    // when
        baseController.printPage();
    // then
        verify(response).print("1.停车服务\n" +
                "2.停车场管理\n" +
                "请输入您要进入的页面：\n");
    }
}
