package com.example.demo;

import com.example.demo.config.SwaggerConfig;
import org.junit.jupiter.api.Test;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SwaggerConfigTest {

    private final SwaggerConfig swaggerConfig = new SwaggerConfig();

    @Test
    void testPublicApiGroup() {
        // Arrange

        // Act
        GroupedOpenApi groupedOpenApi = swaggerConfig.publicApi();

        // Assert
        assertNotNull(groupedOpenApi);
        assertEquals("public", groupedOpenApi.getGroup());

        // Convert list to string for assertion
        List<String> expectedPaths = Arrays.asList("/**");
        assertEquals(expectedPaths.toString(), groupedOpenApi.getPathsToMatch().toString());
    }
}


