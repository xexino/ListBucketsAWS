package com.aymanAwsCode;

import java.util.List;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

public class ListBuckets {
    public static  void  main(String[] args){
        Region region = Region.US_EAST_1;

        S3Client client = S3Client.builder().region(region).build();

        ListBucketsRequest  request = ListBucketsRequest.builder().build();
        ListBucketsResponse response = client.listBuckets(request);

        List<Bucket> buckets = response.buckets();

        for(Bucket bucket : buckets) {
            System.out.println(bucket.name()  +  "  -  " + bucket.creationDate());
        }
    }
}
