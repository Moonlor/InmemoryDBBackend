package com.gc.inmemorydb.core.service.system.impl;

import com.gc.inmemorydb.core.dto.system.resource.ResourceDTO;
import com.gc.inmemorydb.core.service.system.SysResourceService;
import com.gc.inmemorydb.core.entity.system.SysResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import java.util.List;

/**
 * @author licoy.cn
 * @version 2018/4/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceServiceImplTest {


    @Autowired
    private SysResourceService resourceService;

    @Test
    public void list() {
        List<SysResource> list = resourceService.list();
        System.out.println();
    }

    @Test
    public void add() {

        ResourceDTO resourceDTO = new ResourceDTO();
        resourceDTO.setName("测试");
        resourceService.add(resourceDTO);

    }

    @Test
    public void update() {

        ResourceDTO resourceDTO = new ResourceDTO();
        resourceDTO.setName("测试666");
//        resourceService.update("987948959588683778",resourceDTO);
        resourceService.update("987948959588683776",resourceDTO);

    }

    @Test
    public void remove() {

//        resourceService.remove("54545");
        resourceService.remove("987948959588683778");

    }
}