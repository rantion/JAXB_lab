package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 12/7/13
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class PerformAction {
    private String prompt;

    public PerformAction(String prompt) {
        this.prompt = prompt;

    }

    public String getPrompt() {
        return prompt;
    }

    public abstract void execute_Action();

}
