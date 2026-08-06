package io.aidevcopilot.plugin.notification;

import com.intellij.openapi.ui.Messages;

public final class NotificationService {

    private NotificationService() {
    }

    public static void success(
            String message
    ) {

        Messages.showInfoMessage(
                message,
                "AI Dev Copilot"
        );

    }

    public static void error(
            String message
    ) {

        Messages.showErrorDialog(
                message,
                "AI Dev Copilot"
        );

    }

    public static void warning(
            String message
    ) {

        Messages.showWarningDialog(
                message,
                "AI Dev Copilot"
        );

    }

}