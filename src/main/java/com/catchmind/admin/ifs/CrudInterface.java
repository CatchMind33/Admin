package com.catchmind.admin.ifs;

import com.catchmind.admin.model.network.Header;

public interface CrudInterface<Req,Res>{
    // 요청(데이터)을 받아 insert 후, Header<Res>로 응답
    Header<Res> create(Header<Req> request);
    
    // id값을 받아서, select 후 Header<Res>로 응답
    Header<Res> read(Long id);

    // 요청(데이터)를 받아 update후, Header<Res>로 응답
    Header<Res> update(Header<Req> request);

    // id값을 받아서, delete 후 Header<Res>로 응답
    Header<Res> delete(Long id);
}
