package io.aidevcopilot.plugin.action;


import io.aidevcopilot.plugin.dto.AITask;

public class SpringAdvisorAction extends GenerationAction {

    @Override
    protected AITask getTask() {
        return AITask.SPRING_BOOT_ADVISOR;
    }
}