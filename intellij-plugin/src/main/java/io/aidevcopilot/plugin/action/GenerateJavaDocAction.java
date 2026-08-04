package io.aidevcopilot.plugin.action;


import io.aidevcopilot.plugin.dto.AITask;

public class GenerateJavaDocAction extends AIAction {

    @Override
    protected AITask getTask() {
        return AITask.GENERATE_JAVADOC;
    }
}