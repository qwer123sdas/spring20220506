package org.zerock.mapper.ex01;

import org.apache.ibatis.annotations.Select;

public interface Ex01Mapper {  // class의 객체 = spring bean
	// ???
	@Select("SELECT 100")
	public int selectNumber();
}
