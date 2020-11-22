package com.lo.web.es.builder;

import java.util.Map;

import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeoLocationBuilder {
	
	@Autowired
	RestHighLevelClient restHighLevelClient;
	
	public void findNearByLocations() {
		
		try {
		
			QueryBuilder queryBuilder = QueryBuilders.geoDistanceQuery("pin.location").point(41.9311, -71.2950)
				      .distance(30, DistanceUnit.KILOMETERS);
			
			SearchRequest searchRequest = new SearchRequest(); 
			searchRequest.indices("geo_city");
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
			searchSourceBuilder.query(queryBuilder); 
			searchSourceBuilder.size(200);
			searchRequest.source(searchSourceBuilder);
			
			SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
			
			SearchHits hits = searchResponse.getHits();
			TotalHits totalHits = hits.getTotalHits();
			
			SearchHit[] searchHits = hits.getHits();
			int i = 0;
			for (SearchHit hit : searchHits) {
			    Map<String, Object> fieldsMap = hit.getSourceAsMap();
			    Object location = fieldsMap.get("location");
			    
			    i++;
			    System.out.println(i + ". - " + location);
			}
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
