package io.aidevcopilot.plugin.action;

import io.aidevcopilot.plugin.action.AIAction;
import io.aidevcopilot.plugin.dto.AITask;

public class BugFinderAction extends AIAction {

    @Override
    protected AITask getTask() {

        return AITask.BUG_FINDER;
    }
}