import org.junit.jupiter.api.Test;
import org.rwelsch.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class BankAccountControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDeposit() throws Exception {
        mockMvc.perform(put("/clients/1/deposit")
                .contentType(MediaType.APPLICATION_JSON)
                .content("100.00"))
                .andExpect(status().isOk());
    }

    @Test
    public void testWithdraw() throws Exception {
        mockMvc.perform(put("/clients/1/withdraw")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("100.00"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetHistory() throws Exception {
        mockMvc.perform(get("/clients/1/history"))
                .andExpect(status().isOk());
    }

    @Test
    public void test404() throws Exception {
        mockMvc.perform(get("/clients/1/operations"))
                .andExpect(status().is4xxClientError());
    }
}
