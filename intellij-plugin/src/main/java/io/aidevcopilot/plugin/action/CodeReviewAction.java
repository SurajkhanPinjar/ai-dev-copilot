package io.aidevcopilot.plugin.action;

import io.aidevcopilot.plugin.dto.AITask;

public class CodeReviewAction extends AnalysisAction {

    @Override
    protected AITask getTask() {
        return AITask.CODE_REVIEW;
    }

}