package io.aidevcopilot.plugin.action;

import io.aidevcopilot.plugin.action.GenerationAction;
import io.aidevcopilot.plugin.dto.AITask;

public class BugFinderAction
        extends GenerationAction {

    @Override
    protected AITask getTask() {

        return AITask.BUG_FINDER;

    }

}