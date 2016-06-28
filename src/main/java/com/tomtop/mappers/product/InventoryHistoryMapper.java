package com.tomtop.mappers.product;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tomtop.dto.product.InventoryHistory;

public interface InventoryHistoryMapper {
	@Insert(" insert into t_inventory_history (creference, clistingid, iqty, iwebsiteid, benabled, ibeforechangeqty, iafterchangeqty, ctype,istorageid) "
			+ "values (#{creference}, #{clistingid}, #{iqty}, #{iwebsiteid}, #{benabled}, #{ibeforechangeqty}, #{iafterchangeqty}, #{ctype},#{istorageid})")
	int insert(InventoryHistory ih);

	@Update("update t_inventory_history set benabled = #{3} where corderid = #{0} and clistingid = #{2} "
			+ "and iwebsiteid = #{1}")
	int updateEnabled(String remark, Integer siteId, String listingId,
			Boolean enabled);

	@Select("select sum(iqty) from t_inventory_history where clistingid = #{0}")
	Integer sumByListingID(String listingID);
}