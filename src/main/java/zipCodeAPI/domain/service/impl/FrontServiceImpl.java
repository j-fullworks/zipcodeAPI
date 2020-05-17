package zipCodeAPI.domain.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import zipCodeAPI.domain.dto.ZipcodeDto;
import zipCodeAPI.domain.service.FrontService;

@Service
public class FrontServiceImpl implements FrontService {


	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	ObjectMapper objectMapper;

    /** 郵便番号検索API リクエストURL */
	/**
	 * ObjectMapper
	 */
//    private static final String URL = "https://zip-cloud.appspot.com/api/search?zipcode=%s";

	/**
	 * JackSon
	 */
    private static final String URL = "https://zip-cloud.appspot.com/api/search?zipcode={zipCode}";

	@Override
	public ZipcodeDto getAddress(String zipCode) {
		ZipcodeDto zipcodeDto = null;;
		try {
			/**
			 * ObjectMapper
			 */
//			java.net.URL url = new java.net.URL(String.format(URL,zipCode));
//			zipcodeDto = objectMapper.readValue(url, ZipcodeDto.class);

			/**
			 * JackSon
			 */
			MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		    List<MediaType> supportedMediaTypes = new ArrayList<>(messageConverter.getSupportedMediaTypes());
		    supportedMediaTypes.add(MediaType.TEXT_PLAIN); // text/plainのJacksonの処理対象にくわえる
		    messageConverter.setSupportedMediaTypes(supportedMediaTypes);
		    restTemplate.setMessageConverters(Collections.singletonList(messageConverter)); // カスタムしたHttpMessageConverterを適用
			zipcodeDto = restTemplate.getForObject(URL, ZipcodeDto.class, zipCode);
		} catch (Exception e) {

		}

		return zipcodeDto;
	}
}
