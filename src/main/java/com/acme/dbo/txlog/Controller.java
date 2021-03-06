package com.acme.dbo.txlog;

import com.acme.dbo.txlog.command.Command;
import com.acme.dbo.txlog.command.NullCommand;

import java.io.IOException;

public class Controller {
    private Command command;

    private Command lastCommand = new NullCommand(null);
    private ConsoleLogWriter writer;

    private int duplicateCount;

    Controller(ConsoleLogWriter writer) {
        this.writer = writer;
    }

    void log(Command command) throws IOException {
        if ((command.getClass().equals(lastCommand.getClass()))) {
            this.command = command.accumulate(this, lastCommand);
            if (lastCommand.getCurrentValue().equals(command.getCurrentValue())) {
                duplicateCount++;
                command = lastCommand;
            } else {
                command = command.accumulate(this, lastCommand);
                duplicateCount = 0;
            }
        } else {
            flush();
        }
        lastCommand = command;
    }

    public void flush() throws IOException {
        writer.write(lastCommand.getDecoratedState(duplicateCount));
        lastCommand.flush();
        duplicateCount = 0;
        lastCommand = new NullCommand("");
        ;
    }
}