package com.prasun.springboot_aws_demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;


@Configuration
public class DynamodbConfig {
	public static final String SERVICE_ENDPOINT="dynamodb.ap-south-1.amazonaws.com";
	public static final String REGION="ap-south-1";
	public static final String ACCESS_KEY="AKIA3TI6ACH7NBAKF67N";
	public static final String SECRET_KEY="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";
	
	@Bean
	public DynamoDBMapper mapper() {
		return new  DynamoDBMapper(amazonDynamoDBConfig());
	}

	

	private AmazonDynamoDB amazonDynamoDBConfig() {
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder
						.EndpointConfiguration(SERVICE_ENDPOINT, REGION))
						.withCredentials(new AWSStaticCredentialsProvider(
								new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY))).build();
						
							
	}
}
