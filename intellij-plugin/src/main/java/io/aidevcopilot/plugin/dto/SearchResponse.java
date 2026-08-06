 package io.aidevcopilot.plugin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * SearchResponse DTO representing the response of a search operation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponse {

    /**
     * The data contained in the search response.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Data data;

    /**
     * Retrieves the data contained in the search response.
     *
     * @return the data object or null if it's not present.
     */
    public Data getData() {
        return data;
    }

    /**
     * Sets the data to be contained in the search response.
     *
     * @param data the data object to set.
     */
    public void setData(Data data) {
        this.data = data;
    }

    /**
     * Inner class representing the data contained in the search response.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {

        /**
         * The answer provided by the search operation.
         */
        private String answer;

        /**
         * Retrieves the answer provided by the search operation.
         *
         * @return the answer string or null if it's not present.
         */
        public String getAnswer() {
            return answer;
        }

        /**
         * Sets the answer provided by the search operation.
         *
         * @param answer the answer string to set.
         */
        public void setAnswer(String answer) {
            this.answer = answer;
        }
    }
}
