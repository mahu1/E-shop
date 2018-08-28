package matti.eshop.service;

import java.util.ArrayList;
import java.util.List;

import matti.eshop.dao.LocationDao;
import matti.eshop.model.Location;

import org.springframework.transaction.annotation.Transactional;

public class LocationServiceImpl implements LocationService {

	private LocationDao locationDao;
	
	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

	private List<LocationDto> toLocationDtos(List<Location> locations) {
		List<LocationDto> dtos = new ArrayList<LocationDto>();
		for(Location location : locations) {
			LocationDto dto = new LocationDto();
			dto.setLocationId(location.getLocationId());
			dto.setDistrict(location.getDistrict());
			dtos.add(dto);
		}
		return dtos;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<LocationDto> getAllLocations() {
		return toLocationDtos(locationDao.getAll());
	}

}
