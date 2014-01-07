package com.brocade.storelocator.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.brocade.storelocator.dao.DatabaseAccessDAO;
import com.brocade.storelocator.dao.DatabaseFactory;
import com.brocade.storelocator.domain.Marker;
import com.brocade.storelocator.request.MarkerRequestInputVO;
import com.brocade.storelocator.request.MarkerResultVO;

public class MarkerServiceImpl implements MarkerService {

	 
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  private String Query = "SELECT address, name, lat, lng, ( 3959 * acos( cos( radians(?) ) * cos( radians( lat ) ) * cos( radians( lng ) - radians(?) ) + sin( radians(?) ) * sin( radians( lat ) ) ) ) AS distance FROM markers HAVING distance < ? ORDER BY distance";
	
	  
	  
	  /*
	   * SELECT id, ( 3959 * acos( cos( radians(37) ) * cos( radians( lat ) ) * cos( radians( lng ) - radians(-122) ) + sin( radians(37) ) * sin( radians( lat ) ) ) )
	   *  AS distance FROM markers HAVING distance < 25 ORDER BY distance LIMIT 0 , 
	   * (non-Javadoc)
	   * 
	   * 
	   * 
	   * @see com.brocade.storelocator.service.MarkerService#getMarkersBasedOnRadius(com.brocade.storelocator.request.MarkerRequestInputVO)
	   */
	  
	  
	@Override
	public List<MarkerResultVO> getMarkersBasedOnRadius(MarkerRequestInputVO markerRequestInputVO) {
		
		/*
		 * get DB Connection
		 * create prepared stmt & get RS
		 * populate markerresultVO
		 * return
		 * 
		 */
		
		List<MarkerResultVO> markerResultVOList = new ArrayList<MarkerResultVO>();
		MarkerResultVO markerResultVO;
		Marker marker;
		DatabaseAccessDAO dao = DatabaseFactory.getInstance();
		Connection connection = dao.getDBConnection();
		System.out.println("DB Connection" + connection);
		
		try {
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setDouble(1, markerRequestInputVO.getCenter_lat());
			preparedStatement.setDouble(2, markerRequestInputVO.getCenter_lng());
			preparedStatement.setDouble(3, markerRequestInputVO.getCenter_lat());
			preparedStatement.setDouble(4, markerRequestInputVO.getDistance());
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				marker = new Marker();
				markerResultVO = new MarkerResultVO();
				marker.setAddress(resultSet.getString(1));
				marker.setName(resultSet.getString(2));
				marker.setLat(resultSet.getDouble(3));
				marker.setLng(resultSet.getDouble(4));
				markerResultVO.setMarker(marker);
				markerResultVO.setDist(resultSet.getDouble(5));
				markerResultVOList.add(markerResultVO);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			try{
				resultSet.close();
				connection.close();	
			} catch(Exception e){
				e.printStackTrace();
			}
			
		}

		return markerResultVOList;
	}

}
