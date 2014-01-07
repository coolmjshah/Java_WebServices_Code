package com.brocade.storelocator.test;

import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import com.brocade.storelocator.request.MarkerRequestInputVO;
import com.brocade.storelocator.request.MarkerResultVO;
import com.brocade.storelocator.service.MarkerServiceImpl;

public class MarkerServiceImplTest {

	@Test
	public void testGetMarkersBasedOnRadius() {
		//fail("Not yet implemented");
		
		MarkerRequestInputVO markerRequestInputVO = new MarkerRequestInputVO();
		MarkerResultVO markerResultVO;
		MarkerServiceImpl impl = new MarkerServiceImpl();
		
		markerRequestInputVO.setCenter_lat(37.386337);
		markerRequestInputVO.setCenter_lng(-122.085823);
		markerRequestInputVO.setDistance(25);
		
		List<MarkerResultVO> list = impl.getMarkersBasedOnRadius(markerRequestInputVO);
		Iterator<MarkerResultVO> i = list.iterator();
		
		while(i.hasNext()){
			markerResultVO = (MarkerResultVO) i.next();
			System.out.println(markerResultVO.getMarker().getAddress());
			System.out.println(markerResultVO.getMarker().getName());
			System.out.println("------------------------------------");
		}
		
	}

}
