package io.aidevcopilot.plugin.action;

import io.aidevcopilot.plugin.dto.AITask;

public class ExplainCodeAction extends AnalysisAction {

    @Override
    protected AITask getTask() {
        return AITask.EXPLAIN_CODE;
    }

}