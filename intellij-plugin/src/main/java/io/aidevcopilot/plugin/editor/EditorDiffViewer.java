//package io.aidevcopilot.plugin.editor;
//
//import com.intellij.diff.DiffManager;
//import com.intellij.diff.contents.DiffContentFactory;
//import com.intellij.diff.requests.SimpleDiffRequest;
//import com.intellij.openapi.editor.Editor;
//import com.intellij.openapi.project.Project;
//
//public final class EditorDiffViewer {
//
//    private EditorDiffViewer() {
//    }
//
//    public static void show(
//            Project project,
//            Editor editor,
//            String originalCode,
//            String generatedCode
//    ) {
//
//        if (project == null ||
//                editor == null ||
//                originalCode == null ||
//                generatedCode == null) {
//            return;
//        }
//
//        SimpleDiffRequest request =
//                new SimpleDiffRequest(
//                        "AI Suggested Changes",
//                        DiffContentFactory.getInstance().create(originalCode),
//                        DiffContentFactory.getInstance().create(generatedCode),
//                        "Current Code",
//                        "AI Generated Code"
//                );
//
//        DiffManager.getInstance()
//                .showDiff(project, request);
//    }
//
//}