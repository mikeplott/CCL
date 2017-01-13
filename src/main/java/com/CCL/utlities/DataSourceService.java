//package com.CCL.utlities;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//import javax.sql.DataSource;
//
///**
// * Created by Mike on 1/13/2017.
// */
//@Service
//public class DataSourceService {
//
//    private final DataSource primaryDataSource;
//    private final DataSource secondaryDataSource;
//
//    @Autowired
//    public DataSourceService(final DataSource primaryDataSource,
//                     @Qualifier("secondaryDataSource") final DataSource secondaryDataSource)  {
//        this.primaryDataSource = primaryDataSource;
//        this.secondaryDataSource = secondaryDataSource;
//    }
//}
