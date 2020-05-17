package zipCodeAPI.domain.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import zipCodeAPI.domain.service.FrontService;

@Service
public class FrontServiceImpl implements FrontService {

//	@Autowired
//	@Qualifier("zipCodeSearchRestTemplate")
	RestTemplate restTemplate = new RestTemplate();

    /** 郵便番号検索API リクエストURL */
    private static final String URL = "https://zip-cloud.appspot.com/api/search?zipcode={zipcode}";

	@Override
	public String getAddress(String zipCode) {
		String zipcodeDto = restTemplate.getForObject(URL, String.class, zipCode);
		return zipcodeDto;
	}
}
