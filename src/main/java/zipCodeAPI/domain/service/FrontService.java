package zipCodeAPI.domain.service;

import zipCodeAPI.domain.dto.ZipcodeDto;

public interface FrontService {

	public ZipcodeDto getAddress(String zipCode);
}
