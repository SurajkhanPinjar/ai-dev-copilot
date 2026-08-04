package io.aidevcopilot.plugin.action;

import io.aidevcopilot.plugin.action.AIAction;
import io.aidevcopilot.plugin.dto.AITask;

public class GenerateTestsAction extends AIAction {

    @Override
    protected AITask getTask() {

        return AITask.GENERATE_TESTS;
    }
}