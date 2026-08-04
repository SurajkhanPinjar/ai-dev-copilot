package io.aidevcopilot.plugin.action;


import io.aidevcopilot.plugin.dto.AITask;

public class ArchitectureReviewAction extends AIAction {

    @Override
    protected AITask getTask() {
        return AITask.ARCHITECTURE_REVIEWER;
    }
}