package io.aidevcopilot.plugin.action;

import io.aidevcopilot.plugin.dto.AITask;

public class SqlExplainAction extends AnalysisAction {

    @Override
    protected AITask getTask() {
        return AITask.SQL_EXPLAIN;
    }

}