package com.acme.dbo.txlog.command;

public class ObjectCommand extends BaseAccumulatedCommand {
    private String DECOR = "reference: ";

    public ObjectCommand(Object message) {
        super(message);
    }

    @Override
    protected String getDecoratedValue(String object, String decor) {
        return super.getDecoratedValue(object, DECOR);
    }
}
