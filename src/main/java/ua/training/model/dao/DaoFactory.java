package ua.training.model.dao;

import ua.training.model.dao.imp.JDBCDaoFactory;

public abstract class DaoFactory {
        private static DaoFactory daoFactory;

    public abstract CarDao createCarDao();
    public abstract ManufacturerDao createManufacturerDao();
    public abstract ShopDao createShopDao();

    public static DaoFactory getInstance(){
            if( daoFactory == null ){
                synchronized (DaoFactory.class){
                    if(daoFactory==null){
                        daoFactory = new JDBCDaoFactory();
                    }
                }
            }
            return daoFactory;
        }
}
