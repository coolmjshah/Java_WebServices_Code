package com.brocade.storelocator.service;
import java.util.List;

import com.brocade.storelocator.request.*;


public interface MarkerService {

	List<MarkerResultVO> getMarkersBasedOnRadius (MarkerRequestInputVO markerRequestInputVO);
	
}
