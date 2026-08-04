package io.aidevcopilot.plugin.action;

import io.aidevcopilot.plugin.action.AIAction;
import io.aidevcopilot.plugin.dto.AITask;

public class OptimizeCodeAction extends AIAction {

    @Override
    protected AITask getTask() {

        return AITask.OPTIMIZE_CODE;
    }
}