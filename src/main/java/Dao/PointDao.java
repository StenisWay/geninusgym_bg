package Dao;

import java.util.List;

import android.bean.Point;

public interface PointDao {
	int insert(Point point);

	List<Point> selectAll();

	Point selectById(Point point);
}
