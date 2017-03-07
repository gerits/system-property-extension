package be.rubengerits.wiremock;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseDefinitionTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;

import java.util.logging.Logger;

public class SystemPropertyTransformer extends ResponseDefinitionTransformer {
	private static final Logger LOGGER = Logger.getLogger(SystemPropertyTransformer.class.getSimpleName());

	private static final String NAME = "system-property-transformer";

	@Override
	public ResponseDefinition transform(Request request, ResponseDefinition responseDefinition, FileSource files, Parameters parameters) {
		if (responseDefinition.hasTransformer(this)) {
			String property = System.getenv(responseDefinition.getProxyBaseUrl());

			LOGGER.info(String.format("Parsing system property %s to %s", responseDefinition.getProxyBaseUrl(), property));

			return ResponseDefinitionBuilder.like(responseDefinition).but()
					.proxiedFrom(property)
					.build();
		}
		return responseDefinition;
	}

	public String getName() {
		return NAME;
	}
}
