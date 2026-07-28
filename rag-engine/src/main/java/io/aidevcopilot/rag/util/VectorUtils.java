package io.aidevcopilot.rag.util;

import io.aidevcopilot.rag.model.EmbeddingChunk;
import io.aidevcopilot.rag.vectorstore.entity.ChunkEmbeddingEntity;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class VectorUtils {

    private VectorUtils() {
    }

    public static String toPgVector(float[] embedding) {

        return Arrays.stream(toDoubleArray(embedding))
                .mapToObj(Double::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }

    private static double[] toDoubleArray(float[] input) {

        double[] result = new double[input.length];

        for (int i = 0; i < input.length; i++) {
            result[i] = input[i];
        }

        return result;
    }

}