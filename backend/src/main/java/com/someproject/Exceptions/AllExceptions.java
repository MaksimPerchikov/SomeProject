package com.someproject.Exceptions;

import com.someproject.Exceptions.interfaces.AllExceptionsInterface;
import com.someproject.operations.console.ShowMeMessageInConsole;
import org.springframework.stereotype.Component;

@Component
public class AllExceptions implements AllExceptionsInterface {

    @Override
    public void showMeExceptionWithMyMessage(String messageError,Exception e) {
       ShowMeMessageInConsole showMeMessageInConsole = new ShowMeMessageInConsole();
       showMeMessageInConsole.showMeMessageInConsoleMethod(messageError+ ". "+e.getMessage());
       throw new RuntimeException();
    }
}
