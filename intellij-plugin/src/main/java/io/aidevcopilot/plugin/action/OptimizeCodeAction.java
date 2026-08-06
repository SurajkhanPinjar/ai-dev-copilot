package io.aidevcopilot.plugin.action;

import io.aidevcopilot.plugin.dto.AITask;

public class OptimizeCodeAction
        extends GenerationAction {

    @Override
    protected AITask getTask() {

        return AITask.OPTIMIZE_CODE;

    }

}