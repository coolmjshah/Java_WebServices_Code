package com.brocade.storelocator.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.brocade.storelocator.request.MarkerRequestInputVO;
import com.brocade.storelocator.request.MarkerResultVO;
import com.brocade.storelocator.service.MarkerServiceImpl;

@Path("/storelocator")
public class RestService {
	

@GET
@Produces(MediaType.TEXT_XML)
@Path("/{req}")
public List<Markers> getMsg() {
	
	List<Markers> markersList = new ArrayList<>();
	Markers markers;
	List<MarkerResultVO> list = new ArrayList<MarkerResultVO>();
	MarkerRequestInputVO markerRequestInputVO = new MarkerRequestInputVO();
	markerRequestInputVO.setCenter_lat(37.386337);
	markerRequestInputVO.setCenter_lng(-122.085823);
	markerRequestInputVO.setDistance(25);
	MarkerServiceImpl impl = new MarkerServiceImpl();
	list = impl.getMarkersBasedOnRadius(markerRequestInputVO);
	
	Iterator i = list.iterator();
	while(i.hasNext()){
		MarkerResultVO markerResultVO = (MarkerResultVO)i.next();
		markers = new Markers();
		markers.setAddress(markerResultVO.getMarker().getAddress());
		markers.setDist(markerResultVO.getDist());
		markers.setLat(markerResultVO.getMarker().getLat());
		markers.setLng(markerResultVO.getMarker().getLng());
		markers.setName(markerResultVO.getMarker().getName());
		markersList.add(markers);
	}

	return markersList;
	

}

}
