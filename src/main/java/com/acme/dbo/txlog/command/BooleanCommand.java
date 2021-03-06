package com.acme.dbo.txlog.command;

public class BooleanCommand extends BaseAccumulatedCommand {
    private String DECOR = "primitive: ";

    public BooleanCommand(boolean message) {
        super(message);
    }

    @Override
    protected String getDecoratedValue(String object, String decor) {
        return super.getDecoratedValue(object, DECOR);
    }
}
