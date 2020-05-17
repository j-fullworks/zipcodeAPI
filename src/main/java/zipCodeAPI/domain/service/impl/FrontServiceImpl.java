package zipCodeAPI.domain.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import zipCodeAPI.domain.dto.ZipcodeDto;
import zipCodeAPI.domain.service.FrontService;

@Service
public class FrontServiceImpl implements FrontService {

//	@Autowired
//	@Qualifier("zipCodeSearchRestTemplate")
	RestTemplate restTemplate = new RestTemplate();

    /** 郵便番号検索API リクエストURL */
    private static final String URL = "https://zip-cloud.appspot.com/api/search?zipcode={zipcode}";

	@Override
	public ZipcodeDto getAddress(String zipCode) {
		ZipcodeDto zipcodeDto = restTemplate.getForObject(URL, ZipcodeDto.class, zipCode);
		return zipcodeDto;
	}
}
