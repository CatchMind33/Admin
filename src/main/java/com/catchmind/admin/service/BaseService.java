package com.catchmind.admin.service;

import com.catchmind.admin.ifs.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public abstract class BaseService<Req,Res> implements CrudInterface<Req,Res> {

}
