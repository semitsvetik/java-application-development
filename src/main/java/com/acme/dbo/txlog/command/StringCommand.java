package com.acme.dbo.txlog.command;

public class StringCommand extends BaseAccumulatedCommand {
    private String DECOR = "string: ";

    public StringCommand(String message) {
        super(message);
    }

    @Override
    protected String getDecoratedValue(String object, String decor) {
        return super.getDecoratedValue(object, DECOR);
    }
}
