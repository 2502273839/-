package com.example.demo.serviceImpl.apply;

import com.example.demo.Util.DateUtil;
import com.example.demo.dao.RoomServiceDAO;
import com.example.demo.entity.RoomDO;
import com.example.demo.entity.RoomUseDO;
import com.example.demo.entity.client.RoomUse;
import com.example.demo.model.ErrorCode;
import com.example.demo.model.request.RoomRequest;
import com.example.demo.model.response.BaseResponse;
import com.example.demo.model.response.QueryRoomResponse;
import com.example.demo.service.apply.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class RoomServiceImpl implements RoomService {

    private static final Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

    @Resource
    RoomServiceDAO roomServiceDAO;

    @Override
    public BaseResponse<QueryRoomResponse> queryRoomUse(RoomRequest request) {
        try {
            Date day = request.getDay();
            List<RoomUseDO> roomUseDOS = roomServiceDAO.queryRoomUseByDay(day);
            HashMap<Integer, List<RoomUseDO>> map = new HashMap();
            for (RoomUseDO roomUseDO : roomUseDOS) {
                if(!map.containsKey(roomUseDO.getRoomid())) {
                    List<RoomUseDO> list = new ArrayList<>();
                    list.add(roomUseDO);
                    map.put(roomUseDO.getRoomid(), list);
                } else {
                    map.get(roomUseDO.getRoomid()).add(roomUseDO);
                }
            }
            List<RoomDO> roomDOS = roomServiceDAO.queryAllRoom();
            QueryRoomResponse response = new QueryRoomResponse();
            response.setTotal(roomDOS.size());
            List<RoomUse> list = new ArrayList<>();
            for (RoomDO roomDO : roomDOS) {
                RoomUse roomUse = new RoomUse();
                roomUse.setRoom(roomDO.getRoomname());
                roomUse.setRoomId(roomDO.getId());
                roomUse.setNums(roomDO.getNums());
                List<RoomUseDO> idList = map.get(roomDO.getId());
                if (idList == null || idList.isEmpty()) {
                    roomUse.setAccessTime("上午；下午；晚上");
                    roomUse.setAccess("true");
                } else {
                    String accessTime = getAccessTime(idList, day);
                    roomUse.setAccessTime(accessTime);
                    roomUse.setAccess("无可用时间".equals(accessTime) ? "false" : "true");
                }
                list.add(roomUse);
            }
            response.setRoomUseList(list);
            return BaseResponse.returnSuccessData(response);
        } catch (Exception e) {
            logger.error("query room use error", e);
            return BaseResponse.returnFailData(ErrorCode.SYSTEM_ERROR.getCode(), ErrorCode.SYSTEM_ERROR.getMessage());
        }
    }

    private String getAccessTime(List<RoomUseDO> useDOS, Date day) {
        StringBuilder sb = new StringBuilder();
        day = DateUtil.getDay(day);
        Date noon = DateUtil.addDayHour(day, 12);
        Date afternoonDate = DateUtil.addDayHour(day, 18);
        Date eveningDate = DateUtil.addDayHour(day, 21);
        Collections.sort(useDOS, new Comparator<RoomUseDO>() {
            @Override
            public int compare(RoomUseDO o1, RoomUseDO o2) {
                return o1.getStart().before(o2.getStart()) ? -1 : 1;
            }
        });
        boolean morning = true, afternoon = true, evening = true;
        for (RoomUseDO roomUseDO : useDOS) {
            if (roomUseDO.getStart().before(noon)) {
                morning = false;
            }
            if (roomUseDO.getStart().before(afternoonDate) && roomUseDO.getStart().after(noon)) {
                afternoon = false;
            }
            if (roomUseDO.getStart().before(eveningDate) && roomUseDO.getStart().after(afternoonDate)) {
                evening = false;
            }
        }
        if (morning) {
            sb.append("上午");
        }
        if (afternoon) {
            sb.append("；下午");
        }
        if (evening) {
            sb.append("；晚上");
        }
        if (sb.charAt(0) == '；') {
            return sb.substring(1);
        }
        return sb.toString();
    }
}
