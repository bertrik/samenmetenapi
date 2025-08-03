package nl.bertriksikken.samenmeten;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public final class SamenMetenClientTest {

    @Test
    public void testCreateApi() {
        SamenMetenClient api = SamenMetenClient.create("http://localhost", Duration.ofSeconds(10));
        assertNotNull(api);
    }
}
