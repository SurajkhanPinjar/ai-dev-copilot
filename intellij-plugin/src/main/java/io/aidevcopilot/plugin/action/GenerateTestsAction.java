package io.aidevcopilot.plugin.action;

import io.aidevcopilot.plugin.action.GenerationAction;
import io.aidevcopilot.plugin.dto.AITask;

public class GenerateTestsAction
        extends GenerationAction {

    @Override
    protected AITask getTask() {

        return AITask.GENERATE_TESTS;

    }

}