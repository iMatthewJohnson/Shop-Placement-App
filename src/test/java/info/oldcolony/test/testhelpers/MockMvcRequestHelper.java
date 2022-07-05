package info.oldcolony.test.testhelpers;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.HashMap;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MockMvcRequestHelper {

    private MockMvc mockMvc;

    public MockMvcRequestHelper(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    public void postQuery(String uri, String query) throws Exception {
        mockMvc.perform(post(uri + query)).andExpect(status().isOk());
    }

    public void postQuery(String uri, HashMap<String, Object> params) throws Exception {
        // Start query with question mark
        StringBuilder query = new StringBuilder("?");
        // iterate through all params keys
        for (String param : params.keySet()) {
            Object value = params.get(param);
            // if the value is null, we just skip writing this param to the query
            if (value == null) continue;
            // if the value is a list of values, then iterate over the list add to the query one by one
            if (value instanceof Iterable) {
                Iterable<Object> valueValues = (Iterable<Object>) value;
                for (Object val : valueValues) {
                    query.append(param)
                            .append("=")
                            .append(val)
                            .append("&");
                }
            // if the value was NOT a list, then just append the param, and it's value to the query
            } else {
                query.append(param)
                        .append("=")
                        .append(params.get(param))
                        .append("&");
            }
        }
        postQuery(uri, query.toString());
    }

    public void postJson(String uri, String json) throws Exception {
        mockMvc.perform(
                post(uri)
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk());
    }

    public String getQuery(String uri, String query) throws Exception {
        ResultActions response = mockMvc.perform(
                get(uri + query))
                .andExpect(status().isOk());
        return response.andReturn().getResponse().getContentAsString();
    }

    public String getQuery(String uri, List<Integer> ids) throws Exception{
        StringBuilder query = new StringBuilder("?");
        ids.forEach(id -> query.append("ids=").append(id).append("&"));
        ResultActions response =  mockMvc.perform(
                get(uri + query))
                .andExpect(status().isOk());
        return response.andReturn().getResponse().getContentAsString();
    }
}
