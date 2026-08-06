package io.aidevcopilot.plugin.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import io.aidevcopilot.plugin.project.model.ProjectAnalysisResult;
import io.aidevcopilot.plugin.project.scope.AnalysisContext;
import io.aidevcopilot.plugin.project.scope.AnalysisScopeResolver;
import io.aidevcopilot.plugin.project.service.ProjectAnalysisService;
import io.aidevcopilot.plugin.toolwindow.ToolWindowManager;

import javax.swing.*;

public class AnalyzeProjectAction extends AnAction {

    private final ProjectAnalysisService service =
            new ProjectAnalysisService();

    private final AnalysisScopeResolver resolver =
            new AnalysisScopeResolver();

    @Override
    public void actionPerformed(
            AnActionEvent event
    ) {

        try {

            AnalysisContext context =
                    resolver.resolve(event);

            ToolWindowManager.setTask(
                    switch (context.getScope()) {

                        case PROJECT ->
                                "Project : " +
                                        context.getProject().getName();

                        case MODULE,
                             PACKAGE,
                             FILE ->
                                context.getRoot().getName();

                    }
            );

            ToolWindowManager.setStatus(
                    "🟡 Scanning Project..."
            );

            ToolWindowManager.clearResponse();

            SwingWorker<ProjectAnalysisResult, Void> worker =
                    new SwingWorker<>() {

                        @Override
                        protected ProjectAnalysisResult doInBackground() {

                            return service.analyze(
                                    context
                            );

                        }

                        @Override
                        protected void done() {

                            try {

                                ProjectAnalysisResult result =
                                        get();

                                ToolWindowManager.showResponse(
                                        result.toString()
                                );

                                ToolWindowManager.setStatus(
                                        "🟢 Scan Complete"
                                );

                            } catch (Exception ex) {

                                ToolWindowManager.setStatus(
                                        "🔴 Error"
                                );

                                JOptionPane.showMessageDialog(
                                        null,
                                        ex.getMessage(),
                                        "AI Dev Copilot",
                                        JOptionPane.ERROR_MESSAGE
                                );

                            }

                        }

                    };

            worker.execute();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "AI Dev Copilot",
                    JOptionPane.ERROR_MESSAGE
            );

        }

    }

}