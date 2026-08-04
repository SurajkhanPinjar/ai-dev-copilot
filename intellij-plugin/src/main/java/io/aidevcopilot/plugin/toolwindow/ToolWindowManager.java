package io.aidevcopilot.plugin.toolwindow;

public final class ToolWindowManager {

    private static AiToolWindowPanel panel;

    private ToolWindowManager() {
    }

    public static void register(AiToolWindowPanel toolWindowPanel) {
        panel = toolWindowPanel;
    }

    public static void showResponse(String response) {

        if (panel != null) {
            panel.setResponse(response);
        }
    }

    public static void setStatus(String status) {

        if (panel != null) {
            panel.setStatus(status);
        }
    }

    public static void setPrompt(String prompt) {

        if (panel != null) {
            panel.setPrompt(prompt);
        }
    }

    public static void clearResponse() {

        if (panel != null) {
            panel.clearResponse();
        }
    }

    public static void setTask(String task) {

        if (panel != null) {
            panel.setTask(task);
        }
    }

    public static void setModel(String model) {

        if (panel != null) {
            panel.setModel(model);
        }

    }
}