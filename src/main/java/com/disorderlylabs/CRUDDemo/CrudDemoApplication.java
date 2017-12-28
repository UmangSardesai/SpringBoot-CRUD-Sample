package com.disorderlylabs.CRUDDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import brave.Tracing;
import brave.opentracing.BraveTracer;
import brave.sampler.Sampler;
import io.opentracing.Tracer;
import zipkin.Span;
import zipkin.reporter.AsyncReporter;
import zipkin.reporter.Encoding;
import zipkin.reporter.okhttp3.OkHttpSender;
import okhttp3.OkHttpClient;

@SpringBootApplication
public class CrudDemoApplication {
	@Bean
    public Tracer zipkinTracer() {
        	OkHttpSender okHttpSender = OkHttpSender.builder()
                	.encoding(Encoding.JSON)
                	.endpoint("http://localhost:9411/api/v1/spans")
                	.build();
	        
		AsyncReporter<Span> reporter = AsyncReporter.builder(okHttpSender).build();
        	Tracing braveTracer = Tracing.newBuilder()
                	.localServiceName("app")
                	.reporter(reporter)
                	.traceId128Bit(true)
                	.sampler(Sampler.ALWAYS_SAMPLE)
                	.build();
	        
		return BraveTracer.create(braveTracer);
    	}
		

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
}
